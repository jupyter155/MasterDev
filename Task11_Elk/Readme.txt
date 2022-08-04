http://172.17.80.25:5601/app/kibana#/dev_tools/console?_g=()

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

