import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class InitDemo {

    public static RestHighLevelClient getClient() {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("172.17.80.25", 9200, "http"),
                        new HttpHost("172.17.80.25", 9201, "http")));

        return client;
    }
}
