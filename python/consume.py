from pykafka import KafkaClient

client = KafkaClient(hosts="localhost:9092")

topic = client.topics['testie']

# Create a consumer
consumer = topic.get_simple_consumer()

# Iterate through messages in the topic
for message in consumer:
    if message is not None:
        print(message.offset, message.value)

