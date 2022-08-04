package controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/completion-suggester")
public class SuggestController {
    @RequestMapping(value = {"/{indice}/{field}/{text}/{size}"}, method = RequestMethod.GET)
    public List<String> searchBySuggestionMethod(@PathVariable String indice, @PathVariable String field, @PathVariable String text, @PathVariable(required = false) Integer size) throws IOException {
        if (size == null) size = 10;
        HashMap<Character, Character[]> charMap = new HashMap<>();
        charMap.put('a', new Character[]{'a','à','á','ả','ã','ạ'});
        charMap.put('â', new Character[]{'â','ầ','ấ','ẩ','ẫ','ậ'});
        charMap.put('ă', new Character[]{'ă','ằ','ắ','ẳ','ẵ','ặ'});
        charMap.put('o', new Character[]{'o','ò','ó','ỏ','õ','ọ'});
        charMap.put('ô', new Character[]{'ô','ồ','ố','ổ','ỗ','ộ'});
        charMap.put('ỡ', new Character[]{'ơ','ờ','ớ','ở','ỡ','ợ'});
        charMap.put('u', new Character[]{'u','ù','ú','ủ','ũ','ụ'});
        charMap.put('ư', new Character[]{'ư','ừ','ứ','ử','ữ','ự'});
        charMap.put('e', new Character[]{'e','è','é','ẻ','ẽ','ẹ'});
        charMap.put('ê', new Character[]{'ê','ề','ế','ể','ễ','ệ'});
        charMap.put('i', new Character[]{'i','ì','í','ỉ','ĩ','ị'});
        charMap.put('y', new Character[]{'y','ỳ','ý','ỷ','ỹ','ỵ'});
        ArrayList<Character> charSpecial = new ArrayList<Character>(Arrays.asList('a','â','ă','o','ô','ơ','u','ư','e','ê','i'));
        char lastChar = text.charAt(text.length()-1);
        String temp = "";
        HashMap<String,Integer> rsMap = new HashMap<>();
        CompletionSuggesterRepo autoCompleteSearchRepository = context.getBean(CompletionSuggesterRepo.class);
        if (charSpecial.contains(lastChar) == true) {
            text = text.substring(0,text.length()-1);
            for (char i : charMap.get(lastChar)) {
                temp = text + i;
                rsMap.putAll(autoCompleteSearchRepository.getSuggestionSearch(field, temp, indice));
            }
        } else {
            rsMap = autoCompleteSearchRepository
                    .getSuggestionSearch(field, text, indice);
        }

        List<String> rsList = new ArrayList<>();
        for (HashMap.Entry<String, Integer> set :
                rsMap.entrySet()) {
            if (size < 1 ) break;
            rsList.add("suggest : " + set.getKey() + " - score : " + set.getValue());
            size -= 1;
        }
        return rsList;
    }
}
