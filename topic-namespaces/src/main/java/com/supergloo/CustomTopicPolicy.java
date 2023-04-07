package com.supergloo;

import java.util.Map;

import javax.naming.Context;

import org.apache.kafka.common.errors.PolicyViolationException;
import org.apache.kafka.server.policy.CreateTopicPolicy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*
* An quick example of a class to enforce topic naming convention in Kafka
*
**/
public class CustomTopicPolicy implements CreateTopicPolicy {

    private static final Logger log = LoggerFactory.getLogger(CustomTopicPolicy.class);

    private static final String ALLOWED_PREFIX = "inventory-";

    @Override
    public void validate(RequestMetadata requestMetadata) throws PolicyViolationException {

        if (!requestMetadata.topic().startsWith(ALLOWED_PREFIX)) {
            throw new PolicyViolationException("Topic names must start with " + ALLOWED_PREFIX);
        }
    }

    @Override
    public void close() throws Exception {
        log.info("Closing custom CreateTopicPolicy");
    }

    @Override
    public void configure(Map<String, ?> configs) {
        if (configs != null) {
            for( String k: configs.keySet()) {
                log.info(configs.get(k).toString());
            }
        }
    }

}
