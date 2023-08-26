package com.marimar.store.infraestructure.rest;

import com.marimar.store.application.dto.BannerDTO;
import com.marimar.store.application.service.BannerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BannerRestController {

    private final BannerService bannerService;

    public BannerRestController(BannerService bannerService) {
        this.bannerService = bannerService;
    }
    @CrossOrigin
    @GetMapping(value = "/bannerimages", produces = "application/json")
    ResponseEntity<List<BannerDTO>> getAllImages(){
        List<BannerDTO> items = this.bannerService.getAllImages();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value ="/bannerimages", produces = "application/json", consumes = "application/json")
    ResponseEntity<BannerDTO> insertImage(@RequestBody BannerDTO bannerDTO){
        BannerDTO bannerSaved = this.bannerService.saveItem(bannerDTO);
        return new ResponseEntity<>(bannerSaved, HttpStatus.CREATED);
    }

}
