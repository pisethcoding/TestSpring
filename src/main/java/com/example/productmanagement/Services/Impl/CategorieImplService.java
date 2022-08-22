package com.example.productmanagement.Services.Impl;

import com.example.productmanagement.Config.StatusMessages;
import com.example.productmanagement.Model.BrandModel;
import com.example.productmanagement.Model.CategorieModel;
import com.example.productmanagement.Repositories.CategorieRepositorie;
import com.example.productmanagement.Services.CategorieService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieImplService implements CategorieService {
    private final StatusMessages statusMessages=new StatusMessages();
    private final CategorieRepositorie categorieRepositorie;

    public CategorieImplService(CategorieRepositorie categorieRepositorie) {
        this.categorieRepositorie = categorieRepositorie;
    }
    @Override
    public List<CategorieModel> categories() {
        return categorieRepositorie.findAllByStatus("ACT");
    }

    @Override
    public CategorieModel findById(Integer id) {
        var categorieFind=categorieRepositorie.findById(id);
        if (categorieFind.isPresent()){
            return categorieFind.get();
        }else {
            return null;
        }
    }

    @Override
    public void create(CategorieModel categorieModel) {
        categorieRepositorie.save(categorieModel);
    }

    @Override
    public CategorieModel update(CategorieModel categorieModel) {
        var categorieFind=categorieRepositorie.findById(categorieModel.getId());
        if (categorieFind.isPresent()){
            categorieRepositorie.save(categorieModel);
        }else {
            return null;
        }
        return null;
    }

    @Override
    public CategorieModel delete(CategorieModel categorieModel) {
        var categorieFind=categorieRepositorie.findById(categorieModel.getId());
        if (categorieFind.isPresent()){
            categorieModel.setStatus(statusMessages.delete);
            categorieRepositorie.save(categorieModel);
        }else {
            return null;
        }
        return null;
    }

}
