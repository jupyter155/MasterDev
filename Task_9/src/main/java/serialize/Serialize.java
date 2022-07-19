package serialize;
import org.apache.kafka.common.serialization.Serializer;
import com.google.protobuf.MessageLite;

public class Serialize <T extends MessageLite> implements Serializer<T>{
    @Override
    public byte[] serialize(String topic, T data) {
        return data.toByteArray();
    }

}
