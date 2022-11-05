package com.example.customwarehousetask.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_to_warehouse",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    )
    private List<Warehouse> warehouseList;
}
