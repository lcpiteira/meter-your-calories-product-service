package com.meter.your.calories.ProductService.models.dto;

import com.meter.your.calories.ProductService.models.enums.FoodGroupEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class FoodDto {
    private String name;
    private FoodGroupEnum food_group;
    private Integer calories;
}
