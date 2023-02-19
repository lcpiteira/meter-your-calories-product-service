package com.meter.your.calories.ProductService.services.impl;

import com.meter.your.calories.ProductService.mappers.FoodMapper;
import com.meter.your.calories.ProductService.models.dto.FoodDto;
import com.meter.your.calories.ProductService.models.entities.FoodEntity;
import com.meter.your.calories.ProductService.repositories.FoodRepository;
import com.meter.your.calories.ProductService.services.FoodService;
import jakarta.transaction.Transactional;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<FoodDto> getAllFoodItems() {
        List<FoodEntity> allFoodList = foodRepository.findAll();
        return FoodMapper.mapFoodEntityListToDtoList(allFoodList);
    }

    @Override
    public FoodEntity createFoodItem(FoodDto foodDto) {
        FoodEntity foodEntity = FoodMapper.mapFoodDtoToFoodEntity(foodDto);
        return foodRepository.save(foodEntity);
    }

    @Override
    public List<FoodEntity> createByFoodItemList(List<FoodDto> foodDtoList) {
        List<FoodEntity> foodEntities = FoodMapper.mapFoodDtoToFoodEntity(foodDtoList);
        return foodRepository.saveAll(foodEntities);
    }

    @Override
    public void deleteFoodItem(String foodName) {
        foodRepository.deleteFoodEntitiesByName(foodName);
    }

    @Override
    public FoodEntity updateFoodItem(String foodName, FoodDto foodDto) throws Exception {
        Optional<FoodEntity> foodEntityOpt = foodRepository.findFoodEntitiesByName(foodName);
        if(foodEntityOpt.isEmpty()){
            throw new Exception("Food Item with name "+foodName+" does not exist");
        }
        FoodEntity foodEntityUpdated = FoodMapper.updateFoodEntity(foodEntityOpt.get(), foodDto);
        return foodRepository.save(foodEntityUpdated);

    }
}
