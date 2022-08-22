package com.example.productmanagement.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_categorie")
@Data
public class CategorieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String status;
}
