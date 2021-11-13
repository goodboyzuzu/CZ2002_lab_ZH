package boundary;

import controller.OrderController;
import controller.StaffController;
import controller.TableController;
import entity.Staff;
import entity.Table;

import java.util.Scanner;

public class OrderUI {
    private OrderController orderController;
    private StaffController staffController;
    private TableController tableController;
    Scanner sc = new Scanner(System.in);

    public OrderUI(){
        orderController = new OrderController();
        staffController = new StaffController();
        tableController = new TableController();
    }

    public void showOrderOptions(){
        int choice;
        do {
            System.out.println("1--> Start Order");
            System.out.println("2--> Print Order Invoice");
            System.out.println("3--> Show Sale Report Revenue");
            System.out.println("4--> Back");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    startOrder();
                    break;
                case 2:
                    printInvoice();
                    break;
                case 3:
                    showReport();
                    break;
                default:
                    break;
            }
        }while (choice!=4);
    }

    private void startOrder(){
        System.out.println("Enter ID of staff");
        Staff staff = staffController.loadStaffs();
        System.out.println(staff.getName()+ " at your service! Please choose one of the available tables");
        Table table = tableController.getAvailTable();
        orderController.startOrder(staff,table);

    }

    private void printInvoice(){
        System.out.println("Under Construction");
    }

    private void showReport(){
        System.out.println("Under Construction");
    }
}
