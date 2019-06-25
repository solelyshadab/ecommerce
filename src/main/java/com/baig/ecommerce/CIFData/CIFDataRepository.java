package com.baig.ecommerce.CIFData;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CIFDataRepository extends MongoRepository<CIFData, Integer> {
    public List<CIFData> findByCustomerName(String name);
}
