package com.cashcrusaders.purchaseorder.entitty;


//import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id", columnDefinition = "int")
    private int supplierId;

    @Column(name = "supplier_name", columnDefinition = "VARCHAR(255)")
    private String supplierName;

}