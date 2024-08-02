package com.inditex.products.infraestructure.database.springdata.repository.jpa;

import com.inditex.products.application.port.out.repository.ProductRepository;
import com.inditex.products.domain.PriceData;
import com.inditex.products.domain.PriceRequest;
import com.inditex.products.infraestructure.database.springdata.mapper.PriceEntityMapper;
import com.inditex.products.infraestructure.database.springdata.model.jpa.PriceEntity;
import com.inditex.products.infraestructure.database.springdata.specification.PriceSpecification;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class SpringDataProductRepository implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;
    private final PriceEntityMapper priceEntityMapper;

    @Override
    public List<PriceData> findByParameters(PriceRequest priceRequest) {

        Specification<PriceEntity> spec = getPriceEntitySpecification(priceRequest);
        return priceEntityMapper.toDomain(jpaProductRepository.findAll(spec));

    }

    @NotNull
    private static Specification<PriceEntity> getPriceEntitySpecification(PriceRequest priceRequest) {

        return PriceSpecification.searchByDateAndAttributes(priceRequest.getDate(),
                priceRequest.getProductId(),
                priceRequest.getBrandId());
    }


}
