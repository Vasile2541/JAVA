package com.step.storeProducts;

import com.step.abstractClassesAndInterfaces.Product;

public class Bread extends Product {
    String color;
    public Bread(String name, String producer, double price, String color) {
        super(name, producer, price);
        this.color = color;
    }

    @Override
    public String toString() {
        return

            "\n\tDescriere produs   = '" + name  + '\'' +
            "\n\tProducatorul       = '" + producer + '\'' +
            "\n\tPret pentru unit.  = '" + price +"' lei"+
            "\n\tCuloare            = '" + color + '\'';
    }
}
