package com.cpadassignment.rentatrend.repository;

import entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users,String> {

    @Query("{userName:'?0'}")
    Users findItemByName(String username);
}
