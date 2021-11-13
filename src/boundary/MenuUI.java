package boundary;

import controller.MenuController;

import java.util.Scanner;

public class MenuUI {
    private MenuController menuController;
    Scanner sc = new Scanner(System.in);

    public MenuUI(){
        menuController = new MenuController();
    }

    public void showMenuOptions() {
        int choice;
        do {
            System.out.println("1--> View Menu Items");
            System.out.println("2--> Add Food Items");
            System.out.println("3--> Remove Food Items");
            System.out.println("4--> Add Promotional Package");
            System.out.println("5--> Back");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    showMenuItem();
                    break;
                case 2:
                    addFoodItem();
                    break;
                case 3:
                    removeMenuItem();
                    break;
                case 4:
                    addPackage();
                    break;
                default:
                    break;
            }
        }while (choice!=5);
    }
    private void showMenuItem(){
        menuController.showMenuItem();
    }


    private void addFoodItem() {
        System.out.println("Enter food name");
        String foodName = sc.nextLine();
        System.out.println("Enter food description");
        String foodDesc = sc.nextLine();
        System.out.println("Enter food price");
        double foodPrice = sc.nextDouble();
        sc.nextLine();
        System.out.println("Course type: (1) MAIN_COURSE (2) DESSERT (3) DRINKS");
        int courseIndex = sc.nextInt();
        menuController.addMenuItem(foodName,foodDesc,foodPrice, courseIndex);

    }

    private void removeMenuItem() {
        System.out.println("Enter the name of the item");
        showMenuItem();
        String menuName = sc.nextLine();
        menuController.removeMenuItem(menuName);
    }

    private void addPackage(){
        System.out.println("Enter the name of Package");
        String packageName = sc.nextLine();
        System.out.println("Enter package description");
        String packageDesc = sc.nextLine();
        System.out.println("Enter package price");
        double packagePrice = sc.nextDouble();
        sc.nextLine();
        menuController.addPackage(packageName,packageDesc,packagePrice);
    }

}
