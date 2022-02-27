package com.step.storeProducts;

import com.step.abstractClassesAndInterfaces.*;

public class Milk extends Product implements IMilk {
    private String fatContent;
    private double volume;

    public Milk(String name, String producer, double price, String fatContent, double volume) {
        super(name, producer, price);
        this.fatContent = fatContent;
        this.volume     = volume;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }

    @Override
    public String getFatContent() {
        return this.fatContent;
    }

    @Override
    public String toString() {
        return
            "\n\tDescriere produs     = '" + name  + '\'' +
            "\n\tProducatorul         = '" + producer + '\'' +
            "\n\tPret pentru unit.    = '" + price +"' lei"+
            "\n\tConcentratie grasimi = '" + fatContent + " %'" +
            "\n\tVolumul              = '" + volume + " ml'";

    }

}
