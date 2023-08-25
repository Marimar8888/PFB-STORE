package com.marimar.store.infraestructure.rest;

import com.marimar.store.application.dto.CarouselDTO;
import com.marimar.store.application.service.CarouselService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CarouselRestController {

    private final CarouselService carouselService;

    public CarouselRestController(CarouselService carouselService) {
        this.carouselService = carouselService;
    }

    @CrossOrigin
    @GetMapping(value = "/carouselimages", produces = "application/json")
    ResponseEntity<List<CarouselDTO>> getAllImages(){
        List<CarouselDTO> items = this.carouselService.getAllImages();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value ="/carouselimages", produces = "application/json", consumes = "application/json")
    ResponseEntity<CarouselDTO> insertImage(@RequestBody CarouselDTO carouselDTO){
        CarouselDTO carouselSaved = this.carouselService.saveItem(carouselDTO);
        return new ResponseEntity<>(carouselSaved, HttpStatus.CREATED);
    }
}
