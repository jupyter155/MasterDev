package tu.cit.examples.kafkaapi;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomerCSV {
    public static void main(String[] args) throws InterruptedException, IOException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        String CSV_FILE_PATH = s +
                "/data/t.csv";

        BufferedWriter buffWriter = new BufferedWriter(new
                FileWriter(CSV_FILE_PATH,true));

        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.17.80.20:9092");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, Integer.MAX_VALUE);
        config.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, Integer.MAX_VALUE);
        config.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, Integer.MAX_VALUE);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "deviceInfo");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String,String>(config);

        kafkaConsumer.subscribe(Arrays.asList(("customer_minhnx12")));

        ConsumerRecords<String, String> recordss =
                kafkaConsumer.poll(Duration.ofMillis(Long.parseLong("10000")));

        ArrayList<Integer> lstID = new ArrayList<Integer>();

        if(!recordss.isEmpty()) {
            for (ConsumerRecord<String, String> record : recordss) {
                String [] x = record.value().split(",");
                try{
                    if (Integer.parseInt(x[1]) > 100 && Integer.parseInt(x[2]) < 20 )  {
                        int id = Integer.parseInt(x[0]);
                        if(lstID.contains(id)) break;
                        lstID.add(id);
                        buffWriter.write(record.value() + System.lineSeparator());
                        System.out.println(record.value() + System.lineSeparator());
                    }
                }
                catch (Exception e) {
                    buffWriter.flush();
                }
            }
        }
        buffWriter.close();
    }
}
