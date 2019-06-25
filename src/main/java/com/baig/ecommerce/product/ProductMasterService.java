package com.baig.ecommerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductMasterService {

    @Autowired
    private ProductMasterRepository productMasterRepository;

    public ProductMaster getProductById(Integer id) {

        return productMasterRepository.findById(id).get();
    }

    public Page<ProductMaster> getProducts(Pageable pageable) {

        return productMasterRepository.findAll(pageable);
    }
}
