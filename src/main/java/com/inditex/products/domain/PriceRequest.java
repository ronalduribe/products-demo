package com.inditex.products.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequest {

    private Timestamp date;

    private String productId;

    private String brandId;

}
