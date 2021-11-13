package helperFunction;

import entity.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PopulateDB {
    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<Staff> staffArrayList = new ArrayList<Staff>();
        ArrayList<MenuItem> menuItemArrayList = new ArrayList<MenuItem>();
        ArrayList<Table> tableArrayList = new ArrayList<Table>();
        ArrayList<Order> orderArrayList = new ArrayList<Order>();

        tableArrayList.add(new Table(2,1));
        tableArrayList.add(new Table(2,2));
        tableArrayList.add(new Table(4,3));
        tableArrayList.add(new Table(4,4));
        tableArrayList.add(new Table(4,5));
        tableArrayList.add(new Table(4,6));
        tableArrayList.add(new Table(6,7));
        tableArrayList.add(new Table(6,8));
        tableArrayList.add(new Table(10,9));

        Staff emp1=new Staff("Zu Hong",1,'F',"waiter");
        Staff emp2=new Staff("Regine",2,'F',"waitress");
        Staff emp3=new Staff("Barnabas",3,'M',"Manager");
        Staff emp4=new Staff("Shaun",4,'F',"Lady Boss");
        Staff emp5=new Staff("Rayner",5,'M',"Big Boss");
        staffArrayList.add(emp1);
        staffArrayList.add(emp2);
        staffArrayList.add(emp3);
        staffArrayList.add(emp4);
        staffArrayList.add(emp5);

        orderArrayList.add(new Order(emp1,520,new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2021")));
        orderArrayList.add(new Order(emp2,1520,new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2021")));
        orderArrayList.add(new Order(emp3,3520,new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2021")));
        orderArrayList.add(new Order(emp4,5520,new SimpleDateFormat("dd/MM/yyyy").parse("02/06/2021")));
        orderArrayList.add(new Order(emp5,6520,new SimpleDateFormat("dd/MM/yyyy").parse("02/07/2021")));
        orderArrayList.add(new Order(emp4,5220,new SimpleDateFormat("dd/MM/yyyy").parse("02/08/2021")));
        orderArrayList.add(new Order(emp3,7220,new SimpleDateFormat("dd/MM/yyyy").parse("02/09/2021")));
        orderArrayList.add(new Order(emp2,7220,new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2021")));
        orderArrayList.add(new Order(emp2,3220,new SimpleDateFormat("dd/MM/yyyy").parse("02/11/2021")));


        Food chicken = new Food("chicken","delicious",4.30, Food.CourseType.MAIN_COURSE);
        Food kangKong = new Food("kang kong","oily",5.00, Food.CourseType.MAIN_COURSE);
        Food sugarCane = new Food("sugar cane","Refreshing",1.20, Food.CourseType.DRINKS);
        Food coke= new Food("coke","fizzy",1.20, Food.CourseType.DRINKS);
        Food cheeseCake = new Food("cheesecake","sweet",6.00, Food.CourseType.DESSERT);

        menuItemArrayList.add(chicken);
        menuItemArrayList.add(kangKong);
        menuItemArrayList.add(sugarCane);
        menuItemArrayList.add(coke);
        menuItemArrayList.add(cheeseCake);

        PromotionalPackage meal1 = new PromotionalPackage("chicken Meal","drumstick and drink",5.00);
        meal1.addItem(chicken);
        meal1.addItem(coke);
        menuItemArrayList.add(meal1);


        // Serialisation
        FileOutputStream staffFile = new FileOutputStream("staffData.db");
        ObjectOutputStream staffOut = new ObjectOutputStream(staffFile);
        FileOutputStream menuItemFile = new FileOutputStream("menuItem.db");
        ObjectOutputStream menuItemOut = new ObjectOutputStream(menuItemFile);
        FileOutputStream tableFile = new FileOutputStream("tableData.db");
        ObjectOutputStream tableOut = new ObjectOutputStream(tableFile);
        FileOutputStream orderFile = new FileOutputStream("orderData.db");
        ObjectOutputStream orderOut = new ObjectOutputStream(orderFile);

        staffOut.writeObject(staffArrayList);
        menuItemOut.writeObject(menuItemArrayList);
        tableOut.writeObject(tableArrayList);
        orderOut.writeObject(orderArrayList);

        staffOut.close();
        staffFile.close();
        menuItemOut.close();
        menuItemFile.close();
        tableOut.close();
        tableFile.close();
        orderOut.close();
        orderFile.close();
    }

}
