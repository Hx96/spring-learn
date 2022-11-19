package com.hx.aop;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author kyle
 */
@Data
@ToString
public class OperationLogDO {

    private Long orderId;

    private LocalDateTime localDateTime;

    private String desc;
}
