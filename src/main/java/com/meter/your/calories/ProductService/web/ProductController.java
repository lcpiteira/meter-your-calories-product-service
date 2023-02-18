package com.meter.your.calories.ProductService.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/test")
    ResponseEntity<String> testGetMethod(){
        return ResponseEntity.ok("Teste OK");
    }

}
