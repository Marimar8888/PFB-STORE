package com.marimar.store.infraestructure.rest;

import com.marimar.store.application.dto.BannerDTO;
import com.marimar.store.application.dto.CategoryImageDTO;
import com.marimar.store.application.service.CategoryImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryImageRestController {

    private final CategoryImageService categoryImageService;

    public CategoryImageRestController(CategoryImageService categoryImageService) {
        this.categoryImageService = categoryImageService;
    }
    @CrossOrigin
    @GetMapping(value = "/categoryImages", produces = "application/json")
    ResponseEntity<List<CategoryImageDTO>> getAllImages(){
        List<CategoryImageDTO> items = this.categoryImageService.getAllImages();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(value ="/categoryImages", produces = "application/json", consumes = "application/json")
    ResponseEntity<CategoryImageDTO> insertImage(@RequestBody CategoryImageDTO categoryImageDTO){
        CategoryImageDTO categoryImageSaved = this.categoryImageService.saveItem(categoryImageDTO);
        return new ResponseEntity<>(categoryImageSaved, HttpStatus.CREATED);
    }
}
