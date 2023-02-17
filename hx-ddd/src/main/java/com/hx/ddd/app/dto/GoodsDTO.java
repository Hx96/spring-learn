package com.hx.ddd.app.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

/**
 * 货物dto
 *
 * @author kyle
 * @date 2023/02/17
 */
@ToString
@Data
public class GoodsDTO {

    private Integer id;
    private String goodsName;
    private Long price;
    private LocalDate createTime;
}
