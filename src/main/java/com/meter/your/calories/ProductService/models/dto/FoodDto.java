package com.meter.your.calories.ProductService.models.dto;

import com.meter.your.calories.ProductService.models.enums.FoodGroupEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FoodDto {
    private String name;
    private String food_group;
    private Integer calories;

    public FoodDto(String name, String food_group, Integer calories) {
        this.name = name;
        this.food_group = food_group;
        this.calories = calories;
    }
}
