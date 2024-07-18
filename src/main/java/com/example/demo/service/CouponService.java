package com.example.demo.service;

import com.example.demo.pojos.CouponPojo;
import com.example.demo.repository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepo couponRepo;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public List<CouponPojo> getallCoupons(String date){
        try {
            return couponRepo.findActiveCouponsForDate(dateFormat.parse(date));
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }
        return null;
    }

    public List<CouponPojo> getCouponById(CouponPojo couponPojo){
        try {
            return couponRepo.findByCouponCode(couponPojo.getCouponCode()) ;
        } catch (Exception e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }
        return null;
    }

    public String saveCoupons(CouponPojo coupon){
        try {
        coupon.setCouponDate(LocalDate.parse(String.valueOf(coupon.getCouponDate())));
        System.out.println(coupon.getCouponDate());
        System.out.println("after");
            couponRepo.save(coupon);
            return "Coupon saved";
        }
        catch (Exception e){
            return "Coupon not saved";
        }
    }

}
