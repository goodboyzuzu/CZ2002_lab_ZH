package boundary;

import controller.ReservationController;

import java.util.Scanner;

public class ReservationUI {
    private ReservationController reservationController;
    Scanner sc = new Scanner(System.in);

    public ReservationUI(){
        reservationController = new ReservationController();
    }

    public void showReservationOptions(){
        int choice;
        do {
            System.out.println("1--> Check reservations");
            System.out.println("2--> Make reservations");
            System.out.println("3--> Remove reservations");
            System.out.println("4--> Check table availability");
            System.out.println("5--> Back");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    checkReservations();
                    break;
                case 2:
                    makeReservations();
                    break;
                case 3:
                    removeReservations();
                    break;
                case 4:
                    checkTable();
                default:
                    break;
            }
        }while (choice!=5);
    }
    private void checkReservations(){
        System.out.println("Under Construction");
    }
    private void makeReservations(){
        System.out.println("Under Construction");
    }
    private void removeReservations(){
        System.out.println("Under Construction");
    }
    private void checkTable(){
        System.out.println("Under Construction");
    }
}
