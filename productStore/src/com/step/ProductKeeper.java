package com.step;

import com.step.abstractClassesAndInterfaces.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductKeeper {
    private List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return products;
    }

    public void addProduct( Product ...prod) {
        this.products.addAll( Arrays.asList(prod) );
//        for (Product p: prod ) {
//            this.products.add( p );
//        }
    }

    public Product getProduct(Product prod) {
        if( products.contains( prod ) ){
            return prod;
        }else {
            System.out.println("\n\tNo such product in Store !!");
            System.out.println("\n\tHere is our products !!");

            return  products.get(0);
        }
    }

}
