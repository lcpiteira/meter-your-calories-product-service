package com.meter.your.calories.ProductService.repositories;

import com.meter.your.calories.ProductService.models.entities.FoodEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
    @Override
    List<FoodEntity> findAll();
}
