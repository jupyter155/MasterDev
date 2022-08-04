import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.SuggestionBuilder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.elasticsearch.search.suggest.term.TermSuggestion;

public class SuggestDemo {

    private static final Logger logger = LogManager.getRootLogger();

    public static void termSuggest() {
        try (RestHighLevelClient client = InitDemo.getClient();) {

            SearchRequest searchRequest = new SearchRequest("title_suggest_minhnx12");

            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

            sourceBuilder.size(0);

            SuggestionBuilder termSuggestionBuilder =
                    SuggestBuilders.termSuggestion("suggest_title").text("Ha");
            SuggestBuilder suggestBuilder = new SuggestBuilder();
            suggestBuilder.addSuggestion("title-suggest", termSuggestionBuilder);
            sourceBuilder.suggest(suggestBuilder);

            searchRequest.source(sourceBuilder);

            SearchResponse searchResponse = client.search(searchRequest);

            if(RestStatus.OK.equals(searchResponse.status())) {
                Suggest suggest = searchResponse.getSuggest();
                TermSuggestion termSuggestion = suggest.getSuggestion("title-suggest");
                for (TermSuggestion.Entry entry : termSuggestion.getEntries()) {
                    logger.info("text: " + entry.getText().string());
                    for (TermSuggestion.Entry.Option option : entry) {
                        String suggestText = option.getText().string();
                        logger.info("   suggest option : " + suggestText);
                    }
                }
            }

        } catch (IOException e) {
            logger.error(e);
        }
    }

//    public static void completionSuggester() {
//        try (RestHighLevelClient client = InitDemo.getClient();) {
//
//            SearchRequest searchRequest = new SearchRequest("title_suggest_minhnx12");
//
//            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//
//            sourceBuilder.size(0);
//
//
//            SuggestionBuilder termSuggestionBuilder =
//                    SuggestBuilders.completionSuggestion("suggest").prefix("lucene s")
//                            .skipDuplicates(true);
//            SuggestBuilder suggestBuilder = new SuggestBuilder();
//            suggestBuilder.addSuggestion("song-suggest", termSuggestionBuilder);
//            sourceBuilder.suggest(suggestBuilder);
//
//            searchRequest.source(sourceBuilder);
//
//            SearchResponse searchResponse = client.search(searchRequest);
//
//            if(RestStatus.OK.equals(searchResponse.status())) {
//                Suggest suggest = searchResponse.getSuggest();
//                CompletionSuggestion termSuggestion = suggest.getSuggestion("song-suggest");
//                for (CompletionSuggestion.Entry entry : termSuggestion.getEntries()) {
//                    logger.info("text: " + entry.getText().string());
//                    for (CompletionSuggestion.Entry.Option option : entry) {
//                        String suggestText = option.getText().string();
//                        logger.info("   suggest option : " + suggestText);
//                    }
//                }
//            }
//
//        } catch (IOException e) {
//            logger.error(e);
//        }
//    }

    public static void main(String[] args) {
        termSuggest();

        logger.info("--------------------------------------");

//        completionSuggester();
    }
}
