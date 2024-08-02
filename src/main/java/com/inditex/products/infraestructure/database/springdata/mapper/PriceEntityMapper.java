package com.inditex.products.infraestructure.database.springdata.mapper;

import com.inditex.products.domain.PriceData;
import com.inditex.products.infraestructure.database.springdata.model.jpa.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {
    @Mapping(target = "brandId", source = "priceDto.brandId.id")
    @Mapping(target = "startDate", source = "priceDto.startDate", qualifiedByName = "getFormattedString")
    @Mapping(target = "endDate", source = "priceDto.endDate", qualifiedByName = "getFormattedString")
    PriceData toDomain(PriceEntity priceDto);

    List<PriceData> toDomain(List<PriceEntity> priceDtoList);

    @Named("getFormattedString")
    default String getFormattedDate(Timestamp date) {

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

    }
}
