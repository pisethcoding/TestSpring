package com.example.productmanagement.Controllers;

import com.example.productmanagement.Config.AlertMessages;
import com.example.productmanagement.Config.StatusMessages;
import com.example.productmanagement.Model.ProductModel;
import com.example.productmanagement.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private AlertMessages messages=new AlertMessages();
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //show all product
    @GetMapping("/products")
    public ResponseEntity<Object> products(){
        List<ProductModel> list=productService.Products();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    //find product base on categorie id
    @GetMapping("/products/categorie/{id}")
    public ResponseEntity<Object> productsCategorieId(@PathVariable("id") Integer categorieId){
        return new ResponseEntity<>(productService.findByCategorie_id(categorieId), HttpStatus.OK);
    }
    //find product base on brand id
    @GetMapping("/products/brand/{id}")
    public ResponseEntity<Object> productsBrandId(@PathVariable("id") Integer brandId) {
        return new ResponseEntity<>(productService.findByBrand_id(brandId), HttpStatus.OK);
    }
    //add product
    @PostMapping("/products/add")
    public ResponseEntity<Object> add(@RequestBody ProductModel productModel){
        if (productModel.getName().equals("") || productModel.getQty()==0 || productModel.getPrice()==0 || productModel.getStatus().equals("")){
            return new ResponseEntity<>(messages.fail,HttpStatus.BAD_REQUEST);
        }else {
            productModel.setSubTotal(productModel.getQty()*productModel.getPrice());
            productService.create(productModel);
            return new ResponseEntity<>(messages.complte,HttpStatus.OK);
        }
    }
    //find product id
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> productId(@PathVariable("id") Integer id){
        return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
    }
    //update product
    @PostMapping("/products/update")
    public ResponseEntity<Object> update(@RequestBody ProductModel productModel){
        if (productModel.getName().equals("") || productModel.getQty()==0 || productModel.getPrice()==0 || productModel.getStatus().equals("")){
            return new ResponseEntity<>(messages.updateFail,HttpStatus.BAD_REQUEST);
        }else {
            productModel.setSubTotal(productModel.getQty()* productModel.getPrice());
            productService.update(productModel);
            return new ResponseEntity<>(messages.update,HttpStatus.OK);
        }
    }
    //delete product
    @PostMapping("/products/delete")
    public ResponseEntity<Object> delete(@RequestBody ProductModel productModel){
        if (productModel.getId()==0){
            return new ResponseEntity<>(messages.deleteFail,HttpStatus.BAD_REQUEST);
        }else {
            productService.delete(productModel);
            return new ResponseEntity<>(messages.delete,HttpStatus.OK);
        }
    }

}
