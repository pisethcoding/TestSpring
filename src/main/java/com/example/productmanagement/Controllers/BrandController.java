package com.example.productmanagement.Controllers;

import com.example.productmanagement.Config.AlertMessages;
import com.example.productmanagement.Model.BrandModel;
import com.example.productmanagement.Model.CategorieModel;
import com.example.productmanagement.Services.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    AlertMessages messages=new AlertMessages();
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    //show all brands
    @GetMapping("/brands")
    public ResponseEntity<Object> brands(){
        List<BrandModel> list=brandService.brands();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    //show brand id
    @GetMapping("/{id}")
    public ResponseEntity<Object> findBrandById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(brandService.findById(id),HttpStatus.OK);
    }
    //add brand
    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody BrandModel brandModel){
        if (brandModel.getName().equals("") || brandModel.getStatus().equals("")){
            return new ResponseEntity<>(messages.fail,HttpStatus.BAD_REQUEST);
        }else {
            brandService.create(brandModel);
            return new ResponseEntity<>(messages.complte,HttpStatus.OK);
        }
    }
    //update brand
    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody BrandModel brandModel){
        if (brandModel.getId()==0 || brandModel.getName().equals("") || brandModel.getStatus().equals("")){
            return new ResponseEntity<>(messages.updateFail,HttpStatus.BAD_REQUEST);
        }else {
            brandService.update(brandModel);
            return new ResponseEntity<>(messages.update,HttpStatus.OK);
        }
    }
    //delete brand
    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody BrandModel brandModel){
        if (brandModel.getId()==0){
            return new ResponseEntity<>(messages.deleteFail,HttpStatus.BAD_REQUEST);
        }else {
            brandService.delete(brandModel);
            return new ResponseEntity<>(messages.delete,HttpStatus.OK);
        }
    }
}
