package com.step.abstractClassesAndInterfaces;

public abstract class Product {
    protected String name;
    protected String producer;
    protected double price;

    public Product(String name, String producer, double price) {
        this.name       = name;
        this.producer   = producer;
        this.price      = price;
    }

    public double getPrice() {
        return price;
    }
}
