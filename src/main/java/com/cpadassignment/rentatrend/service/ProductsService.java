package com.cpadassignment.rentatrend.service;

import com.cpadassignment.rentatrend.repository.ProductsRepository;
import entity.Product;
import entity.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public ProductResponse getListOfProducts() {
        boolean isSuccess = true;
        ProductResponse productResponse = null;
        List<Product> productList = null;
        try {
            productList = productsRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        }
        if(isSuccess)
            productResponse = ProductResponse.builder().products(productList).status(0).errorCode("RAT_0").errorMessage("Fetch Product List Successful").build();
        else
            productResponse = ProductResponse.builder().products(productList).status(1).errorCode("RAT_4").errorMessage("Fetch Product List Failure").build();
        return productResponse;
    }
}
