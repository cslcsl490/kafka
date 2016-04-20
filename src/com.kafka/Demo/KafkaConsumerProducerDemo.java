package com.kafka.Demo;

import com.kafka.consumer.KafkaConsumer;
import com.kafka.interf.KafkaProperties;
import com.kafka.product.KafkaProducer;

/**
 * @author leicui bourne_cui@163.com
 */
public class KafkaConsumerProducerDemo {
    public static void main(String[] args) {
        KafkaProducer producerThread = new KafkaProducer(KafkaProperties.topic);
        producerThread.start();
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
        consumerThread.start();
    }
}