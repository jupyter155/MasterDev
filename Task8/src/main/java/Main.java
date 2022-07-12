import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
public class Main {
    public static void main(String[] args) {

//        SparkSession spark = SparkSession.builder().appName("Read_Parquet_File").getOrCreate();
        SparkSession spark = SparkSession.builder().appName("Read_Parquet_File").master("local").config("spark.driver.bindAddress", "127.0.0.1").getOrCreate();
        Dataset<Row> parquetFileDF = spark.read().parquet("Sample_data/2.parquet"); //file Name
//        Dataset<Row> parquetFileDF = spark.read().parquet("/minhnx12/spark/input/Sample_data/2.parquet"); //file Name HDFS
        parquetFileDF.createOrReplaceTempView("parquetFile");

//---------------------bai3.1--------------------------------

        Dataset<Row> namesDF1 = spark.sql("SELECT device_model,count(Distinct user_id) as count " +
                "FROM parquetFile WHERE device_model is not NUll GROUP BY device_model");
//        namesDF1.repartition(1).write().mode("overwrite").parquet("/user/minhnx12/device_model_num_user2"); file Name HDFS
        namesDF1.repartition(1).write().mode("overwrite").parquet("output/device_model_num_user");
//        namesDF1.show();

//---------------------bai3.2-----------------------------

        Dataset<Row> namesDF2 = spark.sql("SELECT  device_model, collect_set(user_id) as list_user_id " +
                "FROM parquetFile WHERE device_model is not NUll " +
                "GROUP BY device_model");
//        namesDF2.repartition(1).write().mode("overwrite").format("orc").save("/user/minhnx12/device_model_list_user2"); file Name HDFS
        namesDF1.repartition(1).write().mode("overwrite").parquet("output/device_model_list_user");
//        namesDF2.show();

//        ---------------------bai4--------------------

        Dataset<Row> namesDF3 = spark.sql("SELECT (concat_ws('_',user_id, device_model)) as user_id_device_model, button_id, count(*) as count" +
                " FROM parquetFile WHERE button_id is not NUll AND device_model is not NUll  " +
                "GROUP BY user_id_device_model, button_id ");
//        System.out.println(namesDF3.count());
//        namesDF3.repartition(1).write().mode("overwrite").parquet("/user/minhnx12/button_count_by_user_id_device_model2"); file Name HDFS
        namesDF3.repartition(1).write().mode("overwrite").parquet("output/button_count_by_user_id_device_model");
//        namesDF3.show();
    }

}
