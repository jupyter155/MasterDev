package repo;

import config.Config;
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

import java.io.IOException;
import java.util.HashMap;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.apache.logging.log4j.LogManager.getLogger;

public class repo {
    private static final Logger logger = getLogger(repo.class);
    public HashMap<String,Integer> getSuggestionSearch(String field, String text, String indice) throws IOException {
        logger.info("inside suggestion search");
        RestHighLevelClient client = new Config().getClient();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SuggestionBuilder termSuggestionBuilder = SuggestBuilders.completionSuggestion(field).prefix(text).size(10);

        SuggestBuilder suggestBuilder = new SuggestBuilder();
        suggestBuilder.addSuggestion("my-suggest", termSuggestionBuilder);

        searchSourceBuilder.suggest(suggestBuilder);

        SearchRequest searchRequest = new SearchRequest(indice);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        HashMap<String,Integer> rsMap = new HashMap<>();
        StreamSupport.stream(Spliterators.spliteratorUnknownSize(searchResponse.getSuggest().iterator(), Spliterator.ORDERED), false)
                .flatMap(suggestion -> suggestion.getEntries().get(0).getOptions().stream())
                .map((Suggest.Suggestion.Entry.Option option) -> rsMap.put(option.getText().toString(), (int) option.getScore()))
                .collect(Collectors.toList());
        return rsMap;
    }
}
