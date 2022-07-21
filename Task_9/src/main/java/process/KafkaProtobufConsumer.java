package process;

import com.example.Data.DataTracking;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import serialize.Deserialize;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaProtobufConsumer {
    public static void main(String[] args) {
        KafkaProtobufConsumer kafkaProtobufConsumer = new KafkaProtobufConsumer();
        kafkaProtobufConsumer.readMessages();
    }

    public void readMessages() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.17.80.26:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "protobuf-consumer-group");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "serialize.Deserialize");

        properties.put(KafkaProtobufDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://172.17.80.26:8081");
        properties.put(KafkaProtobufDeserializerConfig.SPECIFIC_PROTOBUF_VALUE_TYPE, DataTracking.class.getName());

        KafkaConsumer<String, DataTracking> consumer = new KafkaConsumer<>(properties,
                new StringDeserializer(),
                new Deserialize<>(DataTracking.parser()));

        consumer.subscribe(Collections.singleton("data_tracking_minhnx12"));

        //poll the record from the topic
        while (true) {
            ConsumerRecords<String, DataTracking> records = consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<String, DataTracking> record : records) {
                System.out.println("Message Version: " + record.value().getVersion());
                System.out.println("Message Name: " + record.value().getName());
                System.out.println("Message Timestamp: " + record.value().getTimestamp());
                System.out.println("Message PhoneId: " + record.value().getPhoneId());
                System.out.println("Message Lon: " + record.value().getLon());
                System.out.println("Message Lat: " + record.value().getLat());
            }
            consumer.commitAsync();
        }
    }
}
