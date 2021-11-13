package controller;

import entity.Food;
import entity.MenuItem;
import entity.PromotionalPackage;

import java.io.*;
import java.util.*;

import static helperFunction.FormatAsTable.formatAsTable;

public class MenuController {
    private String menuItemFileName = "menuItem.db";
    private ArrayList<MenuItem> menuItemList;
    Scanner sc = new Scanner(System.in);

    public MenuController() {
        loadFromDatabase();
    }

    public void showMenuItem() {
        List<List<String>> rows = new ArrayList<>();
        List<String> header = Arrays.asList("Category", "Name", "Description", "Price", "Course","Food in package");
        rows.add(header);
        for (MenuItem item : menuItemList) {
            if (!(item instanceof Food)) {
                rows.add(Arrays.asList("Package", item.getName(), item.getDesc(), String.valueOf(item.getPrice()), "-",((PromotionalPackage)item).getFoodString()));
            }
        }
        for (MenuItem item : menuItemList) {
            if (item instanceof Food) {
                Food foodItem = (Food) item;
                List<String> body = Arrays.asList("Food", foodItem.getName(), foodItem.getDesc(), String.valueOf(foodItem.getPrice()), String.valueOf(foodItem.getCoursetype()),"-");
                rows.add(body);
            }
        }
        System.out.println(formatAsTable(rows));
    }

    public void showFoodItem() {
        List<List<String>> rows = new ArrayList<>();
        List<String> header = Arrays.asList("Category", "Name", "Description", "Price", "Course");
        rows.add(header);
        for (MenuItem item : menuItemList) {
            if (item instanceof Food) {
                Food foodItem = (Food) item;
                List<String> body = Arrays.asList("Food", foodItem.getName(), foodItem.getDesc(), String.valueOf(foodItem.getPrice()), String.valueOf(foodItem.getCoursetype()));
                rows.add(body);
            }
        }
        System.out.println(formatAsTable(rows));
    }

//    public void showPackageItem() {
//        List<List<String>> rows = new ArrayList<>();
//        List<String> header = Arrays.asList("Category", "Name", "Description", "Price", "Course");
//        rows.add(header);
//        for (MenuItem item : menuItemList) {
//            if (!(item instanceof Food)) {
//                rows.add(Arrays.asList("Package", item.getName(), item.getDesc(), String.valueOf(item.getPrice()), "-"));
//            }
//        }
//        System.out.println(formatAsTable(rows));
//    }

    public void addMenuItem(String foodName, String foodDesc, double foodPrice, int courseIndex) {
        Food newFood = new Food(foodName, foodDesc, foodPrice, Food.CourseType.values()[courseIndex - 1]);
        boolean contains = false;
        for (MenuItem item : menuItemList) {
            if (item.getName() == foodName)
                contains = true;
        }
        if (contains == false) {
            menuItemList.add(newFood);
            saveToDatabase();
        }
    }

    public void removeMenuItem(String menuName){
        for(Iterator<MenuItem> it = menuItemList.iterator(); it.hasNext();){
            MenuItem menuItem = it.next();
            if((menuItem.getName()).equals(menuName)){
                it.remove();
            }
        }
        saveToDatabase();
    }

    public void addPackage(String packageName, String packageDesc, double packagePrice) {
        PromotionalPackage promo = new PromotionalPackage(packageName, packageDesc, packagePrice);
        System.out.println("Enter name of food to add. Enter \"quit\" to end");
        showFoodItem();
        String foodName;
        do {
            foodName = sc.nextLine();
            System.out.println(foodName);
            for (MenuItem item : menuItemList) {
                if (item.getName().equals(foodName)) {
                    promo.addItem((Food) item);
                }
            }
        } while (!(foodName.equals("quit")));
        menuItemList.add(promo);
        saveToDatabase();
    }

    private void loadFromDatabase() {
        try {
            FileInputStream menuItemFile = new FileInputStream(menuItemFileName);
            ObjectInputStream menuItemIn = new ObjectInputStream(menuItemFile);
            menuItemList = (ArrayList<MenuItem>) menuItemIn.readObject();

            menuItemFile.close();
            menuItemIn.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    private void saveToDatabase() {
        try {
            FileOutputStream menuItemFile = new FileOutputStream(menuItemFileName);
            ObjectOutputStream menuItemOut = new ObjectOutputStream(menuItemFile);

            menuItemOut.writeObject(menuItemList);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }
}
