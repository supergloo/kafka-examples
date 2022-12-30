from pykafka import KafkaClient

# Create a Kafka client
client = KafkaClient(hosts="localhost:9092")

# Get the 'test' topic
topic = client.topics['testie']

# Create a producer
producer = topic.get_sync_producer()

# Send a message to the testie topic
producer.produce(b"Hello Kafka!  Coming to you to live from Python Kafka")

