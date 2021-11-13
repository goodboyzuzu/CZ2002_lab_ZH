package controller;

import boundary.MainUI;
import boundary.MenuUI;
import boundary.OrderUI;
import boundary.ReservationUI;
import entity.MenuItem;
import entity.Staff;

import java.io.*;
import java.util.ArrayList;

public class RestaurantController {
    private MenuController menuController;
    private MenuUI menuUI;
    private OrderUI orderUI;
    private ReservationUI reservationUI;

    public RestaurantController() {
        menuUI= new MenuUI();
        orderUI=new OrderUI();
        reservationUI=new ReservationUI();
    }

    public void chooseFunction(int choice) {

            switch (choice) {
                case 1: //view menu
                    menuUI.showMenuOptions();
                    break;
                case 2:
                    orderUI.showOrderOptions();
                case 3:
                    reservationUI.showReservationOptions();
                default:
                    System.out.println("Did not the correct options");
            }


    }
}
