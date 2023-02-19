package com.meter.your.calories.ProductService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meter.your.calories.ProductService.models.dto.FoodDto;
import com.meter.your.calories.ProductService.services.FoodService;
import com.meter.your.calories.ProductService.web.FoodController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class FoodControllerTests {

    private MockMvc mvc;

    @Mock
    private FoodService foodService;

    @InjectMocks
    private FoodController foodController;

    private JacksonTester<List<FoodDto>> foodDtoList;

    @BeforeEach
    public void setup(){
        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(foodController)
                .build();

    }

    @Test
    public void canRetrieveAllData() throws Exception {
        // given
        given(foodService.getAllFoodItems())
                .willReturn(
                        Stream.of(
                                new FoodDto("Fish and Chips", "MAIN_COURSE", 1200),
                                new FoodDto("Coke", "BEVERAGE", 250)
                        ).collect(Collectors.toList())
                );

        // when
        MockHttpServletResponse response = mvc.perform(
                        MockMvcRequestBuilders.get("/food")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        Assertions.assertEquals(response.getStatus(), HttpStatus.OK.value());
        Assertions.assertEquals(foodDtoList.write(
                Stream.of(
                        new FoodDto("Fish and Chips", "MAIN_COURSE", 1200),
                        new FoodDto("Coke", "BEVERAGE", 250)
                ).collect(Collectors.toList())
        ).getJson(),
                response.getContentAsString());
    }
}
