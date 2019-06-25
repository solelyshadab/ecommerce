package com.baig.ecommerce.productcatalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCatalogueController {

    @Autowired
    private ProductCatalogueService productCatalogueService;

    @CrossOrigin
    @RequestMapping("/products/{category}")
    public List<Product> getAllProductsByCategory(@PathVariable String category){
    return productCatalogueService.getAllProductsByCategory(category);
    }
}
