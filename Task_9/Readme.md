1. Tao folders proto ( file data.proto voi noi dung da cho, protobuf-data-compile.sh)

2. Ta run file protobuf-data-compile.sh, gen ra file java : class DataTracking.java 

3. Class KafkaProtobufProducer de day 10000 len topic:data_tracking_minhnx12 tren kafka

4. Class KafkaProtobufConsumer de consume du lieu tu kafka

5. Class SparkStreaming lay du lieu kafka day len HDFS. partition by year, month, day, hour.

