package com.baig.ecommerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductMasterController {

    @Autowired
    private ProductMasterService productMasterService;

    @CrossOrigin
    @RequestMapping("/productMaster/{id}")
    public ProductMaster getProductMasterById(@PathVariable Integer id){
        return productMasterService.getProductById(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/productMaster/getAll", method = RequestMethod.GET)
    public Page<ProductMaster> getProducts(Pageable pageable){
        return productMasterService.getProducts(pageable);
    }

}
