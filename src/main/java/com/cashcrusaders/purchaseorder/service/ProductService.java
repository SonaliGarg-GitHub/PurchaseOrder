package com.cashcrusaders.purchaseorder.service;

import com.cashcrusaders.purchaseorder.entitty.Product;
import com.cashcrusaders.purchaseorder.repository.ProductRepo;
import com.cashcrusaders.purchaseorder.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierRepo supplierRepo;

    public Product addProduct(Integer supplierId, Product product) {

        return supplierRepo.findById(supplierId).map(supplier -> {
            product.setSupplier(supplier);
            return productRepo.save(product);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Supplier " + supplierId + " doesn't Exist"));
    }

    public Product updateProduct(Integer supplierId, Integer productId, Product product) {

        if(!supplierRepo.existsById(supplierId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Supplier " + supplierId + " doesn't Exist");
        }

        return productRepo.findById(productId).map(p -> {
            product.setProductId(p.getProductId());
            return addProduct(supplierId,product);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product " + productId + "doesn't Exist"));
    }

    public void deleteProduct(Integer productId) {
        productRepo.deleteById(productId);
    }

    public Product find(Integer productId) {
        return productRepo.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product " + productId + " doesn't Exist"));
    }

    public List<Product> findAllBySupplier(Integer supplierId) {
        return productRepo.findAllBySupplier(supplierId);
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }
}