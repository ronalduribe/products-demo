package com.inditex.products.application.port.out.repository;

import com.inditex.products.domain.PriceData;
import com.inditex.products.domain.PriceRequest;

import java.util.List;

public interface ProductRepository {

    List<PriceData> findByParameters(PriceRequest priceRequest);

}
