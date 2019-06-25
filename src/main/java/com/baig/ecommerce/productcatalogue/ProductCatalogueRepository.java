package com.baig.ecommerce.productcatalogue;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ProductCatalogueRepository extends MongoRepository<ProductCatalogue, Integer> {
    public List<ProductCatalogue> findByCategory(String category);
}
