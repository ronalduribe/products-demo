package com.inditex.products.application.usecases;

import com.inditex.products.application.port.in.FindPrice;
import com.inditex.products.application.port.out.repository.ProductRepository;
import com.inditex.products.domain.PriceData;
import com.inditex.products.domain.PriceRequest;
import com.inditex.products.domain.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

@Slf4j
@RequiredArgsConstructor
public class FindPriceUseCase implements FindPrice {

    private final ProductRepository repository;

    @Override
    public PriceData apply(PriceRequest priceRequest) {

      List<PriceData> priceDataList = repository.findByParameters(priceRequest);

      return priceDataList.stream()
                .sorted(Comparator.comparing(PriceData::getPrice)
                        .thenComparing(PriceData::getPriority, Comparator.reverseOrder()))
              .reduce(getPriceDataBinaryOperator())
                .orElseThrow(() -> new NotFoundException("product"));
    }

    @NotNull
    private BinaryOperator<PriceData> getPriceDataBinaryOperator() {
        return (a, b) -> a.getPriority() >= b.getPriority() ? a : b;
    }


}
