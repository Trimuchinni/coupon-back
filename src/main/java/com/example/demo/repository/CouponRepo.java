package com.example.demo.repository;

import com.example.demo.pojos.CouponPojo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CouponRepo extends MongoRepository<CouponPojo, String> {


    List<CouponPojo> findAll();

    @Query("{'status': 'Active', 'couponDate': ?0}")
    List<CouponPojo> findActiveCouponsForDate(Date date);

    List<CouponPojo> findByCouponCode(String couponCode);
}
