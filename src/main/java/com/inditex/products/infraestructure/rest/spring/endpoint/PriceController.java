package com.inditex.products.infraestructure.rest.spring.endpoint;

import com.inditex.products.application.port.in.FindPrice;
import com.inditex.products.infraestructure.rest.spring.mapper.PriceRestMapper;
import com.products.openapi.api.PriceApi;
import com.products.openapi.model.FindPricePriceRequestParameter;
import com.products.openapi.model.PriceResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class PriceController implements PriceApi {

    private final FindPrice findPrice;

    private final PriceRestMapper priceRestMapper;

    @Override
    public ResponseEntity<PriceResponse> findPrice(FindPricePriceRequestParameter priceRequest) {
        return ResponseEntity.ok(priceRestMapper.toRest(findPrice.apply(priceRestMapper.toDomain(priceRequest))));
    }


}
