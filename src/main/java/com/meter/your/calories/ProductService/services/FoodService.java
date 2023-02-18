package com.meter.your.calories.ProductService.services;

import com.meter.your.calories.ProductService.models.dto.FoodDto;
import com.meter.your.calories.ProductService.models.entities.FoodEntity;

import java.util.List;

public interface FoodService {
    List<FoodDto> getAllFoodItems();
    FoodEntity createFoodItem(FoodDto foodDto);

    void deleteFoodItem(String foodName);

    FoodEntity updateFoodItem(String foodName, FoodDto foodDto) throws Exception;


}
