# Kafka Quotas by Example

As a Kafka cluster operator, how do you ensure clients do not misbehave?  Or how do you prevent the noisy neighbor challenge?  

Kafka quotas is an option to help.

[Kafka Quotas Tutorial](https://supergloo.com/kafka-tutorials/kafka-quotas/)

The Kafka Quota tutorial linked above uses the config files used in this directory.

Kafka Quota Demo steps

1) Start the containers; i.e. docker-compose -f kafka-quotas-example.yml up -d

2) set KAFKA_HOME and BOOT environment variables, For example, export KAFKA_HOME=~/dev/kafka_2.13-2.8.1; export BOOT=localhost:9092

3) Run effects.sh to show throughput of principal alice before with ./effects.sh ./alice-client.properties

4) Set produce and consume quota for alice:  $KAFKA_HOME/bin/kafka-configs.sh --bootstrap-server $BOOT --alter --add-config 'producer_byte_rate=5000000,consumer_byte_rate=5000000' --entity-type users --entity-name alice --command-config ./admin-client.properties

5) Re-run effects.sh to show alice being throttled by the quota.


More description and video shown in page linked above.


Note: this leans heavily on the previous
[Kafka ACL Tutorial](https://supergloo.com/kafka-tutorials/kafka-acl-authorization/)
