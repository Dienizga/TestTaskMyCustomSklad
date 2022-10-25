package com.example.customwarehousetask.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Integer article;

    @Column
    private String name;

    @Column
    private BigDecimal lastPurchase;

    @Column
    private BigDecimal lastSale;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", unique = true)
    private Warehouse warehouse;
}