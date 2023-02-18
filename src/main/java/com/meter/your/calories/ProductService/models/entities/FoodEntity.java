package com.meter.your.calories.ProductService.models.entities;

import com.meter.your.calories.ProductService.models.enums.FoodGroupEnum;
import jakarta.persistence.*;


@Entity
@Table(name = "food")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FOOD_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "FOOD_GROUP")
    @Enumerated(EnumType.STRING)
    private FoodGroupEnum food_group;
    @Column(name = "CALORIES")
    private Integer calories;


}
