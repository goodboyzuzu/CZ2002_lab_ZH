package entity;

import java.awt.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

public class Order implements Serializable {

    private String orderId;
    private Staff staff;
    private Date timestamp;
    private double totalPrice;
    private ArrayList<MenuItem> foodList;
    private Table table;

    public Order(Staff staff, Table table) {
        this.orderId = UUID.randomUUID().toString();
        this.staff = staff;
        this.timestamp = Calendar.getInstance().getTime();
        this.totalPrice =0.0;
        this.foodList = new ArrayList<MenuItem>();
        this.table = table;
    }
    public Order(Staff staff, double price, Date date) {
        this.orderId = UUID.randomUUID().toString();
        this.staff = staff;
        this.timestamp = date;
        this.totalPrice = price;
        this.foodList = new ArrayList<MenuItem>();
        this.table = null;
    }

    public String getOrderId() {
        return orderId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Staff getStaff() {
        return staff;
    }

    public Table getTable() {
        return table;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    public ArrayList<MenuItem> getFoodList() {
        return foodList;
    }

    public void addItem(MenuItem food){
        foodList.add(food);
        totalPrice+= food.getPrice();
    }
}

