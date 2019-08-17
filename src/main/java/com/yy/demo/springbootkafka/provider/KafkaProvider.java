package com.yy.demo.springbootkafka.provider;

import com.alibaba.fastjson.JSONObject;
import com.yy.demo.springbootkafka.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;

/**
 * @author yy
 * @ProjectName spring-boot-kafka
 * @Description: TODO
 * @date 2019/8/17 12:12
 */
@Component
@Slf4j
public class KafkaProvider {

    private static final String TOPIC = "yy";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(long orderId, String orderNum, LocalDateTime createTime){
        Order order = Order.builder()
                .orderId(orderId)
                .orderNum(orderNum)
                .createTime(createTime)
                .build();
        ListenableFuture<SendResult<String,String>> future = kafkaTemplate.send(TOPIC, JSONObject.toJSONString(order));
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("## 发送消息失败 ##");
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("## 发送消息成功 ##");
            }
        });
    }

}
