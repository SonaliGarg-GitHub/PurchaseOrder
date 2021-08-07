package com.cashcrusaders.purchaseorder.entitty;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Set;

@Table(name = "orders")
@Entity
@Data
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", columnDefinition = "int")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "ordered_date", columnDefinition = "DATETIME")
    private Date orderedDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    Set<Items> items;

    @Column(name = "total_tax", precision=8, scale=2)
    private float totalTax;

    @Column(name = "grand_total", precision=8, scale=2)
    private BigDecimal grandTotal;

    public void setGrandTotal(float grandTotal) {
        this.grandTotal = new BigDecimal(grandTotal).setScale(2, RoundingMode.HALF_EVEN);
    }
}