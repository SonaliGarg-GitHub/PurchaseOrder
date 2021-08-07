package com.cashcrusaders.purchaseorder.service;

import com.cashcrusaders.purchaseorder.entitty.Items;
import com.cashcrusaders.purchaseorder.entitty.Orders;
import com.cashcrusaders.purchaseorder.entitty.Product;
import com.cashcrusaders.purchaseorder.entitty.Supplier;
import com.cashcrusaders.purchaseorder.repository.OrdersRepo;
import com.cashcrusaders.purchaseorder.repository.ItemsRepo;
import com.cashcrusaders.purchaseorder.repository.ProductRepo;
import com.cashcrusaders.purchaseorder.repository.SupplierRepo;
import com.cashcrusaders.purchaseorder.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.stream.Collectors.*;

@Service
public class OrderService {

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private ItemsRepo itemsRepo;

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private ProductRepo productRepo;


    public Orders findOrder(Integer orderId) {
        return ordersRepo.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Order " + orderId + " doesn't Exist"));
    }

    public List<Orders> findAll() {
        return ordersRepo.findAll();
    }

    public Orders placeOrder(Orders orders) {
        return ordersRepo.save(orders);
    }

    @Transactional
    public Orders placeOrder(Map<String, Integer> product_qty) {

        AtomicReference<Float> grandTotal = new AtomicReference<>((float) 0);

        List<Integer> ids = product_qty.keySet().stream().map(Integer::parseInt).collect(toList());
        List<Product> orderedItems = productRepo.findAllByIds(ids);

        if(orderedItems.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"You can't place a blank order!! Please add an item.");
        }

        Map<Supplier, List<Product>> suppliersList=orderedItems.stream().collect(groupingBy(Product::getSupplier));

        if(suppliersList.keySet().size()>1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One order can have only one supplier");
        }

        Set<Items> items = new HashSet<>();
        Supplier supplier = suppliersList.keySet().iterator().next();

        orderedItems.forEach(product->{
            Items item = new Items();
            item.setProduct(product);
            item.setPurchasedAtPrice(product.getPrice());
            item.setQuantity(product_qty.get(String.valueOf(product.getProductId())));
            item.setSubTotal(item.getQuantity()*item.getPurchasedAtPrice());
            grandTotal.updateAndGet(v -> (float) (v + item.getSubTotal()));
            items.add(item);
        });


        Orders order = new Orders();
        order.setOrderedDate(new Date());
        order.setSupplier(supplier);
        order.setTotalTax(Constants.GST);
        order.setGrandTotal(grandTotal.get()*(1+Constants.GST/100));
        order.setItems(items);
        return placeOrder(order);
    }

}