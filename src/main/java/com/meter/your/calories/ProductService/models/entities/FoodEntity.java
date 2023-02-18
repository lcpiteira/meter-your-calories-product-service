package com.meter.your.calories.ProductService.models.entities;

import com.meter.your.calories.ProductService.models.enums.FoodGroupEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "food")
@Getter
@Setter
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
