package com.meter.your.calories.ProductService.mappers;

import com.meter.your.calories.ProductService.models.dto.FoodDto;
import com.meter.your.calories.ProductService.models.entities.FoodEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.catalina.mapper.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FoodMapper {

    public static FoodDto mapFoodEntityToDto(FoodEntity foodEntity){
        return
                FoodDto
                        .builder()
                        .name(foodEntity.getName())
                        .food_group(foodEntity.getFood_group().name())
                        .calories(foodEntity.getCalories())
                        .build();
    }

    public static List<FoodDto> mapFoodEntityListToDtoList(List<FoodEntity> foodEntityList){
        return
                foodEntityList
                        .stream()
                        .map(FoodMapper::mapFoodEntityToDto)
                        .collect(Collectors.toList());
    }


}
