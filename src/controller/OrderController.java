package controller;

import boundary.MenuUI;
import entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrderController {
    private String orderFileName = "orderData.db";
    private String foodFileName = "menuItem.db";
    private ArrayList<Order> orderList;
    private ArrayList<MenuItem> foodList;

    Scanner sc = new Scanner(System.in);

    public OrderController(){
        openFromDatabase();
    }

    public void startOrder(Staff staff,Table table){
        String choice="";
        Order order = new Order(staff,table);
        System.out.println("Please enter food of your choice");
        MenuController menuController = new MenuController();
        menuController.showMenuItem();
        do{
        choice = sc.nextLine();
        for (MenuItem item : foodList){
            if (item.getName().equals(choice)){
                order.addItem(item);
            }
        }} while (!(choice.equals("quit")));
        orderList.add(order);
        saveToDatabase();
    }



    public ArrayList<Order> getOrderList() {
        return orderList;
    }


    private void openFromDatabase()  {
        try {

//            Deserialize order file
            FileInputStream orderFile = new FileInputStream(orderFileName);
            ObjectInputStream orderIn = new ObjectInputStream(orderFile);

            this.orderList = (ArrayList<Order>) orderIn.readObject();

            orderFile.close();
            orderIn.close();

//            Deserialize Food file
            FileInputStream foodFile = new FileInputStream(foodFileName);
            ObjectInputStream foodIn = new ObjectInputStream(foodFile);

            this.foodList = (ArrayList<MenuItem>) foodIn.readObject();

            foodFile.close();
            foodIn.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught; im at order controller");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    private void saveToDatabase() {
        try {
            FileOutputStream foodFile = new FileOutputStream(foodFileName);
            ObjectOutputStream foodOut = new ObjectOutputStream(foodFile);

            foodOut.writeObject(foodList);

            FileOutputStream orderFile = new FileOutputStream(orderFileName);
            ObjectOutputStream orderOut = new ObjectOutputStream(orderFile);

            foodOut.writeObject(orderList);
        } catch (IOException ex) {
            System.out.println("IOException is caught. Im at order controller");
        }
    }
}
