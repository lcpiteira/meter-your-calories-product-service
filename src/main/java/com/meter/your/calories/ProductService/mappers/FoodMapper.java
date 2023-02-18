package com.meter.your.calories.ProductService.mappers;

import com.meter.your.calories.ProductService.models.dto.FoodDto;
import com.meter.your.calories.ProductService.models.entities.FoodEntity;
import com.meter.your.calories.ProductService.models.enums.FoodGroupEnum;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.catalina.mapper.Mapper;

import java.util.List;
import java.util.Locale;
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

    public static FoodEntity mapFoodDtoToFoodEntity(FoodDto foodDto){
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setFood_group(FoodGroupEnum.valueOf(foodDto.getFood_group().toLowerCase(Locale.ROOT)));
        foodEntity.setName(foodEntity.getName());
        foodEntity.setCalories(foodEntity.getCalories());
        return foodEntity;
    }

    public static FoodEntity updateFoodEntity(FoodEntity foodEntity, FoodDto foodDto){
        foodEntity.setFood_group(FoodGroupEnum.valueOf(foodDto.getFood_group().toLowerCase(Locale.ROOT)));
        foodEntity.setName(foodDto.getName());
        foodEntity.setCalories(foodDto.getCalories());
        return foodEntity;
    }




    public static List<FoodDto> mapFoodEntityListToDtoList(List<FoodEntity> foodEntityList){
        return
                foodEntityList
                        .stream()
                        .map(FoodMapper::mapFoodEntityToDto)
                        .collect(Collectors.toList());
    }

    public static List<FoodEntity> mapFoodDtoToFoodEntity(List<FoodDto> foodDtoList){
        return
                foodDtoList
                        .stream()
                        .map(foodDto -> {
                            FoodEntity foodEntity = new FoodEntity();
                            foodEntity.setFood_group(FoodGroupEnum.valueOf(foodDto.getFood_group().toUpperCase(Locale.ROOT)));
                            foodEntity.setName(foodDto.getName());
                            foodEntity.setCalories(foodDto.getCalories());
                            return foodEntity;
                        })
                        .collect(Collectors.toList());
    }




}
