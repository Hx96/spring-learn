package com.hx.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35762
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
  private Long id;
  private String serial;
}
