package com.inditex.products.application.usecases;

import com.inditex.products.application.port.out.repository.ProductRepository;
import com.inditex.products.domain.PriceData;
import com.inditex.products.domain.PriceRequest;
import com.inditex.products.domain.enums.CurrencyEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import static org.mockito.Mockito.*;

class FindPriceUseCaseTest {
    @Mock
    ProductRepository repository;
    @Mock
    Logger log;
    @InjectMocks
    FindPriceUseCase findPriceUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testApply() {
        when(repository.findByParameters(any())).thenReturn(getPriceDataList());

        PriceData result = findPriceUseCase.apply(new PriceRequest(Timestamp.valueOf("2020-06-14 16:00:00"), "35455", "1"));
        Assertions.assertEquals(new PriceData(1L, "2020-06-14 15:00:00", "2020-06-14 18:30:00", 2, 35455L, 1, new BigDecimal("25.45"), CurrencyEnum.EUR), result);
    }

    private List<PriceData> getPriceDataList(){

        return List.of(
                new PriceData(1L, "2020-06-14 00:00:00", "2020-12-31 23:59:59", 1, 35455L, 0, new BigDecimal("35.50"), CurrencyEnum.EUR),
                new PriceData(1L, "2020-06-14 15:00:00", "2020-06-14 18:30:00", 2, 35455L, 1, new BigDecimal("25.45"), CurrencyEnum.EUR));
    }
}

