package com.meter.your.calories.ProductService.web;

import com.meter.your.calories.ProductService.models.dto.FoodDto;
import com.meter.your.calories.ProductService.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
    @GetMapping("/food")
    ResponseEntity<List<FoodDto>> getAllFoodItemsUsingGet(){
        return ResponseEntity.ok(foodService.getAllFoodItems());
    }

    @PostMapping(value = "/food")
    public ResponseEntity<Void> createFoodItemUsingPost(@RequestBody List<FoodDto> foodDtoList) {
        foodService.createByFoodItemList(foodDtoList);
        return new ResponseEntity<Void>( HttpStatus.OK );
    }

    @DeleteMapping(value = "/food/{name}")
    public ResponseEntity<Void> deleteFoodItemUsingPost(@PathVariable String name){
        foodService.deleteFoodItem(name);
        return new ResponseEntity<Void>( HttpStatus.OK );
    }

    @PutMapping(value = "/food/{name}")
    public ResponseEntity updateFoodItemUsingPost(@PathVariable String name, @RequestBody FoodDto foodDto){
        try {
            foodService.updateFoodItem(name,foodDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
       return new ResponseEntity<Void>( HttpStatus.OK );
    }



}
