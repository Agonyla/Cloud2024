package com.agony.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO {

    private Integer id;

    private String payNo;

    private String orderNo;

    private Integer userId;

    private BigDecimal amount;
}
