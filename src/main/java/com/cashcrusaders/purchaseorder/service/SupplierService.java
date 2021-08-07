package com.cashcrusaders.purchaseorder.service;

import com.cashcrusaders.purchaseorder.entitty.Supplier;
import com.cashcrusaders.purchaseorder.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    public Supplier updateSupplier(Integer supplierId, Supplier supplier) {

        if(!supplierRepo.existsById(supplierId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Supplier " + supplierId + " doesn't Exist");
        }
        supplier.setSupplierId(supplierId);
        return addSupplier(supplier);
    }

    public void deleteSupplier(Integer supplierId) {
        supplierRepo.deleteById(supplierId);
    }

    public Supplier find(Integer supplierId) {
        return supplierRepo.findById(supplierId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Supplier " + supplierId + " doesn't Exist"));
    }

    public List<Supplier> showAllSuppliers() {
        return supplierRepo.findAll();
    }

}