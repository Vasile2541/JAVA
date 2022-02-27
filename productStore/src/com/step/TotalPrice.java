package com.step;

import com.step.abstractClassesAndInterfaces.Product;

import java.text.DecimalFormat;

public class TotalPrice {
    public double totalPrice( Product ...product){
        double totalPrice = 0 ;
        for (Product p: product) {
            totalPrice += p.getPrice();
        }
        return Double.parseDouble(new DecimalFormat("##.##").format( totalPrice ));
    }
}
