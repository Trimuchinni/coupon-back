package com.example.demo.controller;


import com.example.demo.pojos.CouponPojo;
import com.example.demo.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CouponController{


    @Autowired
    private CouponService couponService;

    @GetMapping("/coupon")
    public List<CouponPojo> getallCoupons(@RequestParam String date){
        System.out.println("Inside getallCoupons");
        System.out.println(date);
        return couponService.getallCoupons(date);
    }

    @GetMapping("/couponId")
    public CouponPojo getCouponById(@RequestParam CouponPojo couponPojo){
        System.out.println("Inside getCouponById");
        return (CouponPojo) couponService.getCouponById(couponPojo);
    }

    @PostMapping("/coupon")
    public String saveCoupons(@RequestBody CouponPojo coupon){
        try {
            String rr=couponService.saveCoupons(coupon);
//            System.out.println(coupon.getCouponDate());
            return "Coupon saved";
        }
        catch (Exception e){
            return "Coupon not saved";
        }
    }

}
