#!/bin/bash
#
# To use: 
# 1. set KAFKA_HOME and BOOT env variables
# 2. call this script with which command config file to use, for example
#    ./effects.sh ./alice-client.properties 
#

for i in 10 100 1000 10000 100000; do
  echo ""
  echo $i
  $KAFKA_HOME/bin/kafka-producer-perf-test.sh \
    --topic test_topic \
    --num-records $((1000*1024*1024/$i))\
    --record-size $i\
    --throughput -1 \
    --producer.config $1 \
    --producer-props acks=all \
    bootstrap.servers=$BOOT \
    buffer.memory=67108864 \
    batch.size=128000
done;
