package com.baig.ecommerce.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProductMasterPagedRepository extends PagingAndSortingRepository<ProductMaster, Integer> {
    @Query("Select s from  Something s "
            + "join s.somethingelse as se "
            + "where se.id = :somethingelseid ")
    Page<ProductMaster> findById(@Param("id") Integer id,
                                              Pageable pageable);
}
