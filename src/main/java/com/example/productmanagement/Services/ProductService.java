package com.example.productmanagement.Services;

import com.example.productmanagement.Model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductModel> Products();
    void create(ProductModel productModel);
    ProductModel findById(Integer id);
    List<ProductModel> findByCategorie_id(Integer id);
    List<ProductModel> findByBrand_id(Integer id);
    ProductModel update(ProductModel productModel);
    ProductModel delete(ProductModel productModel);
}
