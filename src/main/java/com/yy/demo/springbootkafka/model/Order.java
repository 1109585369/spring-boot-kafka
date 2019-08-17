package com.yy.demo.springbootkafka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yy
 * @ProjectName spring-boot-kafka
 * @Description: TODO
 * @date 2019/8/17 12:12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    /**
     * 订单id
     */
    private long orderId;
    /**
     * 订单号
     */
    private String orderNum;
    /**
     * 订单创建时间
     */
    private LocalDateTime createTime;
}
