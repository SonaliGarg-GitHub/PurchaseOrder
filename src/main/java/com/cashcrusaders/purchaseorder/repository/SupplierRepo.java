package com.cashcrusaders.purchaseorder.repository;

import com.cashcrusaders.purchaseorder.entitty.Orders;
import com.cashcrusaders.purchaseorder.entitty.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Integer> {

}

