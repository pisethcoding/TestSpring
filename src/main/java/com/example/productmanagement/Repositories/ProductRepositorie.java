package com.example.productmanagement.Repositories;

import com.example.productmanagement.Model.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositorie extends CrudRepository<ProductModel,Integer> {
    List<ProductModel> findAllByStatus(String status);
    List<ProductModel> findByCategorieModel_IdAndStatus(Integer id,String status);
    List<ProductModel> findByBrandModelIdAndStatus(Integer id,String status);
 }
