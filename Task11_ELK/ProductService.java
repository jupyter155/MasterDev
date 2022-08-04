import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.SuggestionBuilder;
import org.elasticsearch.search.suggest.term.TermSuggestion;
import org.elasticsearch.search.suggest.term.TermSuggestionBuilder;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static org.apache.logging.log4j.LogManager.getLogger;

@Component
public class ProductService {

    public static void main(String[] args) throws IOException {
        suggestProducts();
    }
    private static final Logger logger = getLogger(ProductService.class);

    public static void suggestProducts() throws IOException {

        ClientConfiguration clientConfiguration =
                ClientConfiguration.builder().connectedTo("172.17.80.25:9200").build();
        RestHighLevelClient client = RestClients.create(clientConfiguration).rest();

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SuggestionBuilder<TermSuggestionBuilder> termSuggestionBuilder =
                SuggestBuilders.termSuggestion("suggest_title").text("Hà");
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        suggestBuilder.addSuggestion("title-suggest", termSuggestionBuilder);
        searchSourceBuilder.suggest(suggestBuilder);

        SearchRequest searchRequest = new SearchRequest("title_suggest_minhnx12");
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse;
        searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        Suggest suggest = searchResponse.getSuggest();
        TermSuggestion termSuggestion = suggest.getSuggestion("title-suggest");
        for (TermSuggestion.Entry entry : termSuggestion.getEntries()) {
            for (TermSuggestion.Entry.Option option : entry) {
                String suggestText = option.getText().string();
                logger.info(suggestText);
                System.out.println("2");
                System.out.println(suggestText);
                System.out.println("1");
            }
        }
    }
}
