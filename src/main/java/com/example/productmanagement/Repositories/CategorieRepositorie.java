package com.example.productmanagement.Repositories;

import com.example.productmanagement.Model.CategorieModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategorieRepositorie extends CrudRepository<CategorieModel,Integer> {
    List<CategorieModel> findAllByStatus(String status);
}
