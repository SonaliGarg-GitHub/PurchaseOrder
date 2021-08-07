package com.cashcrusaders.purchaseorder.repository;

import com.cashcrusaders.purchaseorder.entitty.Product;
import com.cashcrusaders.purchaseorder.entitty.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM PRODUCT WHERE PRODUCT_ID IN (:id)", nativeQuery = true)
    List<Product> findAllByIds(@Param("id") List<Integer> productIds);

    @Query(value = "SELECT * FROM PRODUCT WHERE SUPPLIER_ID = ?1", nativeQuery = true)
    List<Product> findAllBySupplier(@Param("supplierId") Integer supplierId);
}

