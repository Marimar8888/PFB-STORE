package com.marimar.store.infraestructure.rest;

import com.marimar.store.application.dto.ItemDTO;
import com.marimar.store.application.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemRestController {

    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping(value = "/items-old", produces = "application/json")
    ResponseEntity<List<ItemDTO>> getAllItems(){
        List<ItemDTO> items = this.itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value = "/categories/{idCategory}/items", produces = "application/json")
    ResponseEntity<List<ItemDTO>> getAllItemsFromCategory(@PathVariable Long idCategory){
        List<ItemDTO> items = this.itemService.getAllItemsByCategory(idCategory);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/items", produces = "application/json")
    ResponseEntity<Page<ItemDTO>> getItemsByCriteriaPaged(@RequestParam(value="filter", required = false) String filter, Pageable pageable){
        Page<ItemDTO> items = this.itemService.getItemByCriteriaStringPaged(pageable, filter);
        return new ResponseEntity<Page<ItemDTO>>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value ="/items", produces = "application/json", consumes = "application/json")
    ResponseEntity<ItemDTO> insertItem(@RequestBody ItemDTO itemDTO){
        ItemDTO itemSaved = this.itemService.saveItem(itemDTO);
        return new ResponseEntity<>(itemSaved, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PatchMapping(value ="/items", produces = "application/json", consumes = "application/json")
    ResponseEntity<ItemDTO> updateItem(@RequestBody ItemDTO itemDTO){
        ItemDTO itemUpdate = this.itemService.saveItem(itemDTO);
        return new ResponseEntity<>(itemUpdate, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/items/{itemId}")
    ResponseEntity<?> deleteItemById(@PathVariable Long itemId){
        this.itemService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value = "/items/{itemId}")
    ResponseEntity<ItemDTO> getItemById(@PathVariable Long itemId){
        Optional<ItemDTO> item = this.itemService.getItemById(itemId);
        if(item.isPresent()){
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
