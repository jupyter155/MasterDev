package process;

import com.example.Data.DataTracking;
import com.github.javafaker.Faker;
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

        String topic = "data_tracking_minhnx12";
        int partition = 0;
        Faker faker = new Faker();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHH");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long TS = Long.parseLong(sdf1.format(timestamp));
        //prepare the message

        for(int i = 0; i < 10000; i ++){

        DataTracking dataTracking =
                DataTracking.newBuilder()
                        .setVersion("version-" + faker.number().numberBetween(1, 9) + "." + faker.number().numberBetween(0, 20))
                        .setName(faker.name().fullName())
                        .setTimestamp(TS)
                        .setPhoneId(faker.phoneNumber().phoneNumber())
                        .setLon(faker.number().numberBetween(0, 999))
                        .setLat(faker.number().numberBetween(0, 999)).build();

        //prepare the kafka record
            ProducerRecord<String, DataTracking> record
                    = new ProducerRecord<>(topic, partition,"key1", dataTracking);
            producer.send(record);
            System.out.println(dataTracking);
        }
    }
}
