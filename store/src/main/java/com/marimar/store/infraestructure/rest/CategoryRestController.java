package com.marimar.store.infraestructure.rest;

import com.marimar.store.application.dto.CategoryDTO;
import com.marimar.store.application.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    //Método para consultar todas las cateogrías
    @CrossOrigin
    @GetMapping(value = "/categories", produces = "application/json")
    ResponseEntity<List<CategoryDTO>> getAllCategories(@RequestParam(value = "partialName", required = false) String partialName){
        List<CategoryDTO> categories;
        if(partialName == null){
            categories = this.categoryService.getAllCategories();
        }else{
            categories = this.categoryService.getAllCategoriesByName(partialName);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    //Método para insertar una categoría
    @CrossOrigin
    @PostMapping(value = "/categories", produces = "application/json", consumes = "application/json")
    ResponseEntity<CategoryDTO> insertCategory(@RequestBody CategoryDTO categoryDTO){
        categoryDTO = this.categoryService.saveCategory(categoryDTO);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }
}
