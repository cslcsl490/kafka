package com.kafka.Demo;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 2016/4/19.
 */
public class kafkaProducerDemo extends Thread{

    private String topic;

    public kafkaProducerDemo(String topic){
        super();
        this.topic = topic;
    }


    @Override
    public void run() {
        Producer producer = createProducer();
        int i=0;
        while(true){
            producer.send(new KeyedMessage<Integer, String>(topic, "message: " + i++));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Producer createProducer() {
        Properties properties = new Properties();
        properties.put("zookeeper.connect", "115.159.115.60:2181");//声明zk
        properties.put("serializer.class", StringEncoder.class.getName());
        properties.put("metadata.broker.list", "115.159.115.60:9092");// 声明kafka broker
        return new Producer<Integer, String>(new ProducerConfig(properties));
    }


    public static void main(String[] args) {
        new kafkaProducerDemo("my-replicated-topic").start();// 使用kafka集群中创建好的主题 test

    }
}
