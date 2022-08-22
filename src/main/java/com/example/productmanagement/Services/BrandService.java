package com.example.productmanagement.Services;

import com.example.productmanagement.Model.BrandModel;
import com.example.productmanagement.Model.CategorieModel;

import java.util.List;

public interface BrandService {
    List<BrandModel> brands();
    BrandModel findById(Integer id);
    void create(BrandModel brandModel);
    BrandModel update(BrandModel brandModel);
    BrandModel delete(BrandModel brandModel);
}
