package com.hx.ddd.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * 货物
 *
 * @author kyle
 * @date 2023/02/17
 */
@Data
@Builder
@ToString
public class Goods {

    private Integer id;
    private String name;
    private Long price;
}
