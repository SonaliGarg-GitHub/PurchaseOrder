package com.cashcrusaders.purchaseorder.controller;

import com.cashcrusaders.purchaseorder.entitty.Product;
import com.cashcrusaders.purchaseorder.entitty.Supplier;
import com.cashcrusaders.purchaseorder.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PutMapping
    public Supplier addSupplier(@RequestBody Supplier supplier) {
        return supplierService.addSupplier(supplier);
    }

    @PutMapping("/{supplierId}")
    public Supplier updateSupplier(@PathVariable("supplierId")  Integer supplierId, @RequestBody Supplier supplier) {
        return supplierService.updateSupplier(supplierId,supplier);
    }

    @PostMapping("/delete/{supplierId}")
    public void deleteSupplier(@PathVariable("supplierId")  Integer supplierId) {
        supplierService.deleteSupplier(supplierId);
    }
    
    @GetMapping("/{supplierId}")
    public Supplier findById(@PathVariable("supplierId")  Integer supplierId) {
        return supplierService.find(supplierId);
    }

    @GetMapping
    public List<Supplier> showAllSuppliers() {
        return supplierService.showAllSuppliers();
    }
}
