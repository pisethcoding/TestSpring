package com.example.productmanagement.Repositories;

import com.example.productmanagement.Model.BrandModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BrandRepositorie extends CrudRepository<BrandModel,Integer> {
    List<BrandModel> findAllByStatus(String status);
}
