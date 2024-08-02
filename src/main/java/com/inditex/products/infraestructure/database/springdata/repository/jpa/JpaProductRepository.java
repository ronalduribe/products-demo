package com.inditex.products.infraestructure.database.springdata.repository.jpa;

import com.inditex.products.infraestructure.database.springdata.model.jpa.PriceEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProductRepository extends JpaRepository<PriceEntity, Long>, JpaSpecificationExecutor<PriceEntity> {
    List<PriceEntity> findAll(Specification<PriceEntity> spec);
    List<PriceEntity> findByProductId(Long id);

}
