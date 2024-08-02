package com.inditex.products.infraestructure.rest.spring.endpoint;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PriceController priceController;

    @Test
    public void testFindPriceUseCase1() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/price?productId=35455&brandId=1&date=2020-06-14 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("productId", Matchers.is("35455")))
                .andExpect(MockMvcResultMatchers.jsonPath("brandId", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("priceList", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("startDate", Matchers.is("2020-06-14 00:00:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("endDate", Matchers.is("2020-12-31 23:59:59")))
                .andExpect(MockMvcResultMatchers.jsonPath("price", Matchers.is("35.50")));
    }

    @Test
    public void testFindPriceUseCase2() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/price?productId=35455&brandId=1&date=2020-06-14 16:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("productId", Matchers.is("35455")))
                .andExpect(MockMvcResultMatchers.jsonPath("brandId", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("priceList", Matchers.is("2")))
                .andExpect(MockMvcResultMatchers.jsonPath("startDate", Matchers.is("2020-06-14 15:00:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("endDate", Matchers.is("2020-06-14 18:30:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("price", Matchers.is("25.45")));
    }

    @Test
    public void testFindPriceUseCase3() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/price?productId=35455&brandId=1&date=2020-06-14 21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("productId", Matchers.is("35455")))
                .andExpect(MockMvcResultMatchers.jsonPath("brandId", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("priceList", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("startDate", Matchers.is("2020-06-14 00:00:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("endDate", Matchers.is("2020-12-31 23:59:59")))
                .andExpect(MockMvcResultMatchers.jsonPath("price", Matchers.is("35.50")));
    }

    @Test
    public void testFindPriceUseCase4() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/price?productId=35455&brandId=1&date=2020-06-15 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("productId", Matchers.is("35455")))
                .andExpect(MockMvcResultMatchers.jsonPath("brandId", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("priceList", Matchers.is("3")))
                .andExpect(MockMvcResultMatchers.jsonPath("startDate", Matchers.is("2020-06-15 00:00:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("endDate", Matchers.is("2020-06-15 11:00:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("price", Matchers.is("30.50")));
    }

    @Test
    public void testFindPriceUseCase5() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/price?productId=35455&brandId=1&date=2020-06-14 19:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("productId", Matchers.is("35455")))
                .andExpect(MockMvcResultMatchers.jsonPath("brandId", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("priceList", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("startDate", Matchers.is("2020-06-14 00:00:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("endDate", Matchers.is("2020-12-31 23:59:59")))
                .andExpect(MockMvcResultMatchers.jsonPath("price", Matchers.is("35.50")));
    }

    @Test
    public void testFindPriceUseCase6() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/price?productId=35455&brandId=1&date=2020-06-15 12:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("productId", Matchers.is("35455")))
                .andExpect(MockMvcResultMatchers.jsonPath("brandId", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("priceList", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("startDate", Matchers.is("2020-06-14 00:00:00")))
                .andExpect(MockMvcResultMatchers.jsonPath("endDate", Matchers.is("2020-12-31 23:59:59")))
                .andExpect(MockMvcResultMatchers.jsonPath("price", Matchers.is("35.50")));
    }


    @Test
    public void testFindPriceWithDayOutOfRange() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/price?productId=35455&brandId=1&date=2020-06-13 18:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    @Test
    public void testFindPriceWithProductNotExist() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/price?productId=35435&brandId=1&date=2020-06-13 18:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

}
