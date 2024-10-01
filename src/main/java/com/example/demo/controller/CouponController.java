package com.example.demo.controller;


import com.example.demo.helper.JWThelper;
import com.example.demo.pojos.CouponPojo;
import com.example.demo.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class CouponController{


    @Autowired
    private CouponService couponService;

    @Autowired
    private JWThelper jwThelper;

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

//    @GetMapping("/login")
//    public  String getUser(Principal principal){
//        System.out.println(principal.getName());
//        return principal.getName();
//    }
//    @PostMapping("/kalki")
//    public  String getUser(Principal principal){
//        System.out.println(principal.getName());
//        return principal.getName();
//    }
    @PostMapping("/kalki")
    public  ResponseEntity<Object> getUser(@RequestBody String body, @RequestHeader Map<String ,String> header){
        System.out.println("post jalaja");
        String userName=jwThelper.getSecretKey(body);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:4200/donate?couponId="+userName)).build();
    }

    @GetMapping("/kalki")
    public  String getUserg(){
        System.out.println("get jalaja");
        return "get jalaja";
    }

}
