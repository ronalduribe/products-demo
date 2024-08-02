package com.inditex.products.infraestructure.rest.spring.endpoint;

import com.inditex.products.application.port.in.FindPrice;
import com.inditex.products.domain.PriceData;
import com.inditex.products.domain.PriceRequest;
import com.inditex.products.domain.enums.CurrencyEnum;
import com.inditex.products.infraestructure.rest.spring.mapper.PriceRestMapper;
import com.products.openapi.api.PriceApiDelegate;
import com.products.openapi.model.FindPricePriceRequestParameter;
import com.products.openapi.model.PriceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import static org.mockito.Mockito.*;

class PriceControllerTest {
    @Mock
    FindPrice findPrice;
    @Mock
    PriceRestMapper priceRestMapper;
    @Mock
    Logger log;
    @InjectMocks
    PriceController priceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindPrice() {
        when(findPrice.apply(any())).thenReturn(new PriceData(1L, "2020-06-14 15:00:00", "2020-06-14 18:30:00", 2, 35455L, 1, new BigDecimal("25.45"), CurrencyEnum.EUR));
        when(priceRestMapper.toDomain(any())).thenReturn(new PriceRequest(Timestamp.valueOf("2020-06-14 16:00:00"), "35455", "1"));
        when(priceRestMapper.toRest(any())).thenReturn(getPriceResponse());

        ResponseEntity<PriceResponse> result = priceController.findPrice(new FindPricePriceRequestParameter());
        Assertions.assertEquals(ResponseEntity.ok(getPriceResponse()), result);
    }

    private PriceResponse getPriceResponse() {
        PriceResponse response = new PriceResponse();
        response.productId("35455");
        response.brandId("1");
        response.startDate("2020-06-14 15:00:00");
        response.endDate("2020-06-14 18:30:00");
        response.priceList("2");
        response.price("25.45");
        return response;

    }


}