package com.example.productmanagement.Services;

import com.example.productmanagement.Model.BrandModel;
import com.example.productmanagement.Model.CategorieModel;

import java.util.List;

public interface CategorieService {
    List<CategorieModel> categories();
    CategorieModel findById(Integer id);
    void create(CategorieModel categorieModel);
    CategorieModel update(CategorieModel categorieModel);
    CategorieModel delete(CategorieModel categorieModel);
}
