package com.example.productmanagement.Controllers;

import com.example.productmanagement.Config.AlertMessages;
import com.example.productmanagement.Model.CategorieModel;
import com.example.productmanagement.Services.CategorieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    private AlertMessages messages=new AlertMessages();
    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }
    //show all categories
    @GetMapping("/categories")
    public ResponseEntity<Object> categories(){
        List<CategorieModel> list=categorieService.categories();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    //find categorie by id
    @GetMapping("/{id}")
    public ResponseEntity<Object> categorieId(@PathVariable("id") Integer id){
        return new ResponseEntity<>(categorieService.findById(id),HttpStatus.OK);
    }
    //add categorie
    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody CategorieModel categorieModel){
        if (categorieModel.getName().equals("") || categorieModel.getStatus().equals("")){
            return new ResponseEntity<>("fail !!!",HttpStatus.BAD_REQUEST);
        }else {
            categorieService.create(categorieModel);
            return new ResponseEntity<>("create success ...",HttpStatus.OK);
        }
    }
    //update categorie
    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody CategorieModel categorieModel){
        if (categorieModel.getId()==0||categorieModel.getName().equals("")||categorieModel.getStatus().equals("")){
            return new ResponseEntity<>(messages.updateFail,HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(messages.update,HttpStatus.OK);
        }
    }
    //delete categorie
    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody CategorieModel categorieModel){
      if (categorieModel.getId()==0){
          return new ResponseEntity<>(messages.deleteFail,HttpStatus.BAD_REQUEST);
      }else {
          categorieService.delete(categorieModel);
          return new ResponseEntity<>(messages.delete,HttpStatus.OK);
      }
    }
}
