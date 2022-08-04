http://172.17.80.25:5601

- Import data vao elasticsearch
curl -H 'Content-Type: application/x-ndjson' -XPOST '172.17.80.25:9200/_bulk?pretty' --data-binary @data1.json

Bai1:
    GET /dantri/_search
    {
        "query": {
            "bool" : {
                "must" : [
                    {
                        "multi_match" : {
                            "query":  "an toàn",
                            "type":   "phrase",
                            "fields": [ "title", "description", "content"]
                        }
                    },
                    {
                        "multi_match" : {
                            "query":  "đường bộ",
                            "type":   "phrase",
                            "fields": [ "title", "description", "content"]
                        }
                    },
                    {
                        "multi_match" : {
                            "query":  "đường sắt",
                            "type":   "phrase",
                            "fields": [ "title", "description", "content"]
                        }
                    },
                    {
                        "range": {
                            "time": {
                                "gte": 1356998400,
                                "lt": 1388534400
                            }
                        }
                    }
                ]
            }
        }
    }

Bai2:
    GET /dantri/_search
    {
        "query": {
            "bool" : {
                "must" : {
                    "prefix": {
                    "title.keyword": "Hà Nội"
                }
                },
                "must_not" :{
                    "match_phrase": {
                        "description": {
                            "query": "Hà Nội"
                        }
                    }
                }
            }
        },
        "sort" : [
            { "time" : "desc" }
        ]
    }

Bai3:
 - Tao index:
     PUT title_suggest_minhnx12
     {
         "mappings": {
             "properties" : {
                 "suggest_title" : {
                     "type" : "completion"
                 }
             }
         }
     }
 - Search bang query DSL:
     GET /title_suggest_minhnx12/_search?
     {
         "suggest": {
             "title-suggest" : {
                 "prefix" : "thanh",

                 "completion" : {
                     "field" : "suggest_title",
                     "skip_duplicates": true,
                     "size" : 20
                 }
             }
         }
     }
 - Call api bang postman:
    vd : localhost:8080/completion-suggester/ha
 - Ket qua search voi tu ha:
    [
        "hai cụ",
        "ham muốn",
        "ham mê",
        "hang chùa",
        "hang câu",
        "hang núi",
        "hang sơn đoòng",
        "hang tám cô",
        "hang vàng",
        "hang đá"
    ]
  link tham khao:
  - https://www.anycodings.com/1questions/2815498/suggestrequestbuilderjava-orgelasticsearchactionsuggest-is-missing
  - http://www.aiuxian.com/article/p-cgwinhad-ey.html
