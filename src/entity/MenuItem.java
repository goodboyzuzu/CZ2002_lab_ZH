package entity;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {
    private String name;
    private String desc;
    private double price;

    public MenuItem(String name, String desc, double price){
        this.name=name;
        this.desc=desc;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }
}
