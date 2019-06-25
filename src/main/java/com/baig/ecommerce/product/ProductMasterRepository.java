package com.baig.ecommerce.product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductMasterRepository extends MongoRepository<ProductMaster, Integer> {
    public List<ProductMaster> findByName(String name);

}
