package tu.cit.examples.kafkaapi;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;
import static org.apache.kafka.common.requests.DeleteAclsResponse.log;


public class Producer {
    static Path currentRelativePath = Paths.get("");
    static String s = currentRelativePath.toAbsolutePath().toString();
    static String PATH = s +  "/data/consumer.csv";
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws FileNotFoundException {

        Properties props = new Properties();
        props.put(ProducerConfig.CLIENT_ID_CONFIG,"my-producer-threading-demo");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.17.80.20:9092"); // 172.17.80.20:9092
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(props);

        File file = new File(PATH);
        String topicName = "customer_minhnx12";
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                log.info(line);
                producer.send(new ProducerRecord(topicName,null,line));
            }
            log.info("Finished Sending");
        }
        producer.close();
    }


}
