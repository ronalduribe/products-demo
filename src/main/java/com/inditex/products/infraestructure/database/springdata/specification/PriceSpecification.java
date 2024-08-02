package com.inditex.products.infraestructure.database.springdata.specification;

import com.inditex.products.infraestructure.database.springdata.model.jpa.PriceEntity;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import java.sql.Timestamp;

public class PriceSpecification {

    public static Specification<PriceEntity> searchByDateAndAttributes(Timestamp date, String productId, String brandId) {

        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.greaterThanOrEqualTo(root.get("endDate"), date));
            predicates.add(cb.lessThanOrEqualTo(root.get("startDate"), date));
            predicates.add(cb.equal(root.get("productId"), Long.valueOf(productId)));
            predicates.add(cb.equal(root.get("brandId"), Long.valueOf(brandId)));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
