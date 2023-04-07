# Kafka Namespaces Examples

Kafka does not support namespacing directly, but there are ways we can mimic it.

This folder contains source files used in the

[Kafka Namespaces Tutorial](https://supergloo.com/kafka-tutorials/kafka-namespaces-options/)

If I were you, I'd check out this tutorial link above to see demonstrations and learn more about how to use these source files.  Warning: there is a mystery fish in play. 

But, here is a quick overview of the tutorial.

Namespaces in Kafka may be implemented through Kafka topic naming convention(s) and automated enforcement.  For example, you may configure
a Kafka principal to allow topics to be created, viewed, and managed if, and only if, the topic name starts with the prefix "clickstream".

There are primarily two different ways to implement Kafka topic naming conventions.  

Examples of both methods are provided.

Creating and enforcing this topic naming convention has many benefits which is described in much more detail on the page mentioned above.


