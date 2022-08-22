package com.example.productmanagement.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_product")
@Data
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private CategorieModel categorieModel;
    private String name;
    private int qty;
    private double price;
    private double subTotal;
    private String status;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandModel brandModel;
}