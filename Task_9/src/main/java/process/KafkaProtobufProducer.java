package process;

import com.example.Data.DataTracking;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class KafkaProtobufProducer {
    public static void main(String[] args) {
        KafkaProtobufProducer kafkaProtobufProducer = new KafkaProtobufProducer();
        kafkaProtobufProducer.writeMessage();
    }

    public void writeMessage() {
        //create kafka producer
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.17.80.26:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "serialize.Serialize");
        properties.put(KafkaProtobufSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://172.17.80.26:8081");

        Producer<String, DataTracking> producer = new KafkaProducer<>(properties);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHH");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long TS = Long.parseLong(sdf1.format(timestamp));
        //prepare the message
        DataTracking dataTracking =
                DataTracking.newBuilder()
                        .setVersion("12")
                        .setName("standard")
                        .setTimestamp(TS)
                        .setPhoneId("02323")
                        .setLon(123456)
                        .setLat(123456).build();

        //prepare the kafka record
        while(true) {
            ProducerRecord<String, DataTracking> record
                    = new ProducerRecord<>("minh_test1", "key1", dataTracking);
            producer.send(record);
            System.out.println(dataTracking);
        }
    }
}
