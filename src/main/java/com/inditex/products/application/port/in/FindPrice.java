package com.inditex.products.application.port.in;

import com.inditex.products.domain.PriceData;
import com.inditex.products.domain.PriceRequest;

public interface FindPrice {
    PriceData apply(PriceRequest priceRequest);

}
