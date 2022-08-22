package com.example.productmanagement.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_brand")
@Data
public class BrandModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String status;

}
