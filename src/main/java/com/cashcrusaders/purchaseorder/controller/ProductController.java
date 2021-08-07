package com.cashcrusaders.purchaseorder.controller;

import com.cashcrusaders.purchaseorder.entitty.Product;
import com.cashcrusaders.purchaseorder.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PutMapping("/supplier/{supplierId}/product")
    public Product addProduct(@PathVariable (value = "supplierId") Integer supplierId, @RequestBody Product product) {
       return productService.addProduct(supplierId,product);
    }

    @PutMapping("/supplier/{supplierId}/product/{productId}")
    public Product updateProduct(@PathVariable (value = "supplierId") Integer supplierId,
                                 @PathVariable (value = "productId")  Integer productId,
                                 @RequestBody Product product) {
        return productService.updateProduct(supplierId,productId,product);
    }

    @PostMapping("/product/delete/{productId}")
    public void deleteProduct(@PathVariable (value = "productId")  Integer productId) {
        productService.deleteProduct(productId);
    }

    @GetMapping("/product/{productId}")
    public Product findById(@PathVariable("productId")  int productId) {
        return productService.find(productId);
    }

    @GetMapping("/product")
    public List<Product> findById() {
        return productService.findAll();
    }

    @GetMapping("/supplier/{supplierId}/product")
    public List<Product> findAllBySupplier(@PathVariable("supplierId")  int supplierId) {
        return productService.findAllBySupplier(supplierId);
    }

}
