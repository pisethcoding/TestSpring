package com.example.productmanagement.Services.Impl;

import com.example.productmanagement.Config.StatusMessages;
import com.example.productmanagement.Model.BrandModel;
import com.example.productmanagement.Model.CategorieModel;
import com.example.productmanagement.Repositories.BrandRepositorie;
import com.example.productmanagement.Services.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandImplService implements BrandService {
    private StatusMessages statusMessages=new StatusMessages();
    private final BrandRepositorie brandRepositorie;

    public BrandImplService(BrandRepositorie brandRepositorie) {
        this.brandRepositorie = brandRepositorie;
    }

    @Override
    public List<BrandModel> brands() {
        return brandRepositorie.findAllByStatus(statusMessages.active);
    }

    @Override
    public BrandModel findById(Integer id){
       var brandFind=brandRepositorie.findById(id);
       if (brandFind.isPresent()){
           return brandFind.get();
       }else{
           return null;
       }
    }

    @Override
    public void create(BrandModel brandModel) {
        brandRepositorie.save(brandModel);
    }

    @Override
    public BrandModel update(BrandModel brandModel) {
        var brandFind=brandRepositorie.findById(brandModel.getId());
        if (brandFind.isPresent()){
            brandRepositorie.save(brandModel);
        }else {
            return null;
        }
        return null;
    }

    @Override
    public BrandModel delete(BrandModel brandModel) {
        var brandFind=brandRepositorie.findById(brandModel.getId());
        if (brandFind.isPresent()){
            brandModel.setStatus(statusMessages.delete);
        }
        return null;
    }
}
