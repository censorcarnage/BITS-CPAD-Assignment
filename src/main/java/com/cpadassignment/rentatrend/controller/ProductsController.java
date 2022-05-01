package com.cpadassignment.rentatrend.controller;

import com.cpadassignment.rentatrend.service.ProductsService;
import entity.FinalResponse;
import entity.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping ("/products")
    public ResponseEntity<ProductResponse> registerUser() {
        HttpStatus httpStatus;
        ProductResponse finalResponse = productsService.getListOfProducts();
        if(finalResponse.getStatus() == 0)
            httpStatus = HttpStatus.OK;
        else
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(finalResponse,httpStatus);
    }
}
