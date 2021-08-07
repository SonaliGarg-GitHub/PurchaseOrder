package com.cashcrusaders.purchaseorder.repository;

import com.cashcrusaders.purchaseorder.entitty.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepo extends JpaRepository<Items, Integer> {
}

