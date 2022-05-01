package com.cpadassignment.rentatrend.repository;

import entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Product,String> {
}
