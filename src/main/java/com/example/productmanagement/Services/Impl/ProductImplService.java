package com.example.productmanagement.Services.Impl;

import com.example.productmanagement.Config.StatusMessages;
import com.example.productmanagement.Model.ProductModel;
import com.example.productmanagement.Repositories.ProductRepositorie;
import com.example.productmanagement.Services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImplService implements ProductService {
    private final StatusMessages statusMessages=new StatusMessages();
    private final ProductRepositorie productRepositorie;

    public ProductImplService(ProductRepositorie productRepositorie) {
        this.productRepositorie = productRepositorie;
    }

    @Override
    public List<ProductModel> Products() {
        List<ProductModel> list=productRepositorie.findAllByStatus(statusMessages.active);
        return list;
    }

    @Override
    public void create(ProductModel productModel) {
        productRepositorie.save(productModel);
    }

    @Override
    public ProductModel findById(Integer id) {
        var productFind=productRepositorie.findById(id);
        if (productFind.isPresent()){
            return productFind.get();
        }else {
            return null;
        }
    }

    @Override
    public List<ProductModel> findByCategorie_id(Integer id) {
        return productRepositorie.findByCategorieModel_IdAndStatus(id,statusMessages.active);
    }

    @Override
    public List<ProductModel> findByBrand_id(Integer id) {
        return productRepositorie.findByBrandModelIdAndStatus(id,statusMessages.active);
    }

    @Override
    public ProductModel update(ProductModel productModel) {
        var productFind = productRepositorie.findById(productModel.getId());
        if (productFind.isPresent()) {
            productRepositorie.save(productModel);
        }
        return null;
    }

    @Override
    public ProductModel delete(ProductModel productModel) {
        var productFind=productRepositorie.findById(productModel.getId());
        if (productFind.isPresent()){
            productModel.setStatus(statusMessages.delete);
            productRepositorie.save(productModel);
        }
        return null;
    }
}
