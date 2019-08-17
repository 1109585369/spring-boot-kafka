package com.yy.demo.springbootkafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author yy
 * @ProjectName spring-boot-kafka
 * @Description: TODO
 * @date 2019/8/17 12:11
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "yy",groupId = "group_id")
    public void consume(String message){
        log.info("## 接收消息:{}",message);
    }

}
