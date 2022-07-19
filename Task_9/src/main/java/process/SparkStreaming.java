package process;

import com.example.Data.DataTracking;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.expressions.UserDefinedFunction;
import org.apache.spark.sql.types.DataTypes;
import serialize.Deserialize;

import static org.apache.spark.sql.functions.*;

public class SparkStreaming {
    public static void main(String[] args) throws Exception {

        Logger.getLogger("org").setLevel(Level.OFF);

        // Define a Spark Session
        SparkSession spark = SparkSession
                .builder()
                .appName("Spark Kafka Integration using Structured Streaming")
                .master("local")
                .config("spark.driver.bindAddress", "127.0.0.1")
                .getOrCreate();

        UserDefinedFunction strLen = udf(
                (byte[] data) -> new Deserialize<>(DataTracking.parser()).deserialize("minh_test1", data).toString1()
                , DataTypes.StringType);

        spark.udf().register("strLen", strLen);
        Dataset<Row> ds = spark
                .readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", "172.17.80.26:9092")
                .option("subscribe", "minh_test1")
                .option("startingOffsets", "earliest")
                .load();

        Dataset<Row> DF =
        ds.selectExpr("CAST(key as string)","strLen(value) as value",
                "CAST(topic as STRING)", "CAST(offset as long)", "CAST(partition as long)",
                        "YEAR(timestamp) as year", "MONTH(timestamp) as month",
                        "DAY(timestamp) as day", "hour(timestamp) as hour")
                .select(col("key"),
                        split(col("value"),",").getItem(0).as("version"),
                        split(col("value"),",").getItem(1).as("Name"),
                        split(col("value"),",").getItem(3).as("Phone_Id"),
                        split(col("value"),",").getItem(4).as("Lon"),
                        split(col("value"),",").getItem(5).as("lat"),
                        col("topic"), col("partition"), col("offset"), col("year"),
                        col("month"), col("day"), col("hour"));
        DF.writeStream()
                .outputMode("append")
                .format("parquet")
                .option("checkpointLocation", "checkpoint") //hdfs://172.17.80.27:9000/minhnx12/sparkss/
                .option("path", "output") //hdfs://172.17.80.27:9000/minhnx12/sparkss/
                .partitionBy("year","month", "day", "hour")
                .start().awaitTermination();
    }
}
