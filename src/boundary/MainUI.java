package boundary;

import controller.RestaurantController;

import java.util.Scanner;

public class MainUI {
    static Scanner sc = new Scanner(System.in);
    private RestaurantController restaurant;
    private boolean quit = false;

    public MainUI(){
        restaurant = new RestaurantController();
    }


    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the RRPSS App! Choose an option");
        System.out.println("1--> Menu Options");
        System.out.println("2--> Order Options");
        System.out.println("3--> Reservation Options)");
        System.out.println("4--> Quit Program");
        int input = sc.nextInt();
        sc.nextLine();
        if (input == 4) {
            setQuit(true);
        } else
            restaurant.chooseFunction(input);
    }

    public boolean isQuit() {
        return quit;
    }

    public void setQuit(boolean input) {
        quit = input;
    }
}
