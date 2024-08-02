package com.inditex.products.infraestructure.rest.spring.mapper;

import com.inditex.products.domain.PriceData;
import com.inditex.products.domain.PriceRequest;
import com.products.openapi.model.FindPricePriceRequestParameter;
import com.products.openapi.model.PriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.sql.Timestamp;

@Mapper(componentModel = "spring")
public interface PriceRestMapper {

    @Mapping(target = "date", source = "requestDto.date", qualifiedByName = "getFormattedDate")
    PriceRequest toDomain(FindPricePriceRequestParameter requestDto);

    PriceResponse toRest(PriceData priceData);

    @Named("getFormattedDate")
    default Timestamp getFormattedDate(String date) {

         return Timestamp.valueOf(date);

    }
}
