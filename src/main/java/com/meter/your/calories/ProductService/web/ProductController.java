package com.meter.your.calories.ProductService.web;

import com.meter.your.calories.ProductService.mappers.FoodMapper;
import com.meter.your.calories.ProductService.models.dto.FoodDto;
import com.meter.your.calories.ProductService.models.entities.FoodEntity;
import com.meter.your.calories.ProductService.repositories.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    public ProductController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    private FoodRepository foodRepository;
    @GetMapping("/test")
    ResponseEntity<List<FoodDto>> testGetMethod(){
        List<FoodEntity> allFoodItems = foodRepository.findAll();
        return ResponseEntity.ok(FoodMapper.mapFoodEntityListToDtoList(allFoodItems));
    }

}
