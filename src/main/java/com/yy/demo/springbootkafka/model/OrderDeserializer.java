package com.yy.demo.springbootkafka.model;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * @author yy
 * @ProjectName spring-boot-kafka
 * @Description: TODO
 * @date 2019/8/17 17:15
 */
public class OrderDeserializer implements Deserializer<Order> {

    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }
    @Override
    public Order deserialize(String topic, byte[] bytes) {
    Order order = null;
    ByteArrayInputStream inputStream = null;
    ObjectInputStream objectInputStream = null;
        try {
        inputStream = new ByteArrayInputStream(bytes);
        objectInputStream = new ObjectInputStream(inputStream);
        order = (Order) objectInputStream.readObject();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }finally {
        if(inputStream != null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(objectInputStream != null){
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        return order;
}

    @Override
    public void close() {

    }
}
