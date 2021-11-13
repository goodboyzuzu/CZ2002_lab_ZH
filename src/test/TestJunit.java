package test;

import boundary.MainUI;
import boundary.MenuUI;
import controller.MenuController;
import controller.OrderController;
import controller.StaffController;
import controller.TableController;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class TestJunit {
    @Test
    public void testShowOrder(){
        Assertions.assertDoesNotThrow(()->{
            MenuController menuController = new MenuController();
            menuController.showMenuItem();
        });

    }

    @Test
    public void testOrderController(){
        OrderController orderController= new OrderController();
        if (orderController.getOrderList().size()>2){
            assert true;
        }else{
            assert false;
        }

    }

    @Test
    public void testStaffController(){
        StaffController staffController = new StaffController();
        staffController.loadStaffs();
    }

    @Test
    public void testGetAvailTable(){
        TableController tableController = new TableController();

    }

}
