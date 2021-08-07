package com.cashcrusaders.purchaseorder.entitty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "items")
@Entity
@Data
@NoArgsConstructor
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "purchase_price", precision=8, scale=2)
    private float purchasedAtPrice;

    @Column(name = "quantity", columnDefinition = "int")
    private int quantity;

    @Column(name = "sub_total", precision=8, scale=2)
    private float subTotal;

}