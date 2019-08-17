package com.yy.demo.springbootkafka;

import com.yy.demo.springbootkafka.provider.KafkaProvider;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootKafkaApplicationTests {

    @Autowired
    private KafkaProvider kafkaProvider;

    @Test
    public void sendMessage() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            long orderId = i+1;
            String orderNum = UUID.randomUUID().toString();
            kafkaProvider.sendMessage(orderId,orderNum, LocalDateTime.now());
        }
        TimeUnit.MINUTES.toSeconds(1);
    }

}
