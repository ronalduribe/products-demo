package com.inditex.products.domain;

import com.inditex.products.domain.enums.CurrencyEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceData {

    private Long brandId;

    private String startDate;

    private String endDate;

    private Integer priceList;

    private Long productId;

    private Integer priority;

    private BigDecimal price;

    private CurrencyEnum curr;
}
