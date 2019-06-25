package com.baig.ecommerce.productcatalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCatalogueService {

    @Autowired
    private ProductCatalogueRepository productCatalogueRepository;

    public List<Product> getAllProductsByCategory(String category){
        List<ProductCatalogue> productCatalogues = new ArrayList<>();
        productCatalogues.addAll(productCatalogueRepository.findByCategory(category));
        return productCatalogues.get(0).getProducts();
    }

}
