package controller;

import entity.MenuItem;
import entity.PromotionalPackage;
import entity.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static helperFunction.FormatAsTable.formatAsTable;

public class StaffController {
    private ArrayList<Staff> staffList;
    private String staffFileName = "staffData.db";
    Scanner sc = new Scanner(System.in);

    public StaffController() {
        openFromDatabase();
    }

    public Staff loadStaffs(){
        System.out.println("Please enter the ID of the staff");
        List<List<String>> rows = new ArrayList<>();
        List<String> header = Arrays.asList("Name", "ID", "Gender", "Job title");
        rows.add(header);
        for (Staff staff : staffList){
            rows.add(Arrays.asList(staff.getName(),String.valueOf(staff.getEmpId()),String.valueOf(staff.getGender()),staff.getJobTitle()));
        }
        System.out.println(formatAsTable(rows));
        int empID = sc.nextInt();
        sc.nextLine();
        for (Staff staff : staffList){
            if (staff.getEmpId() == empID){
                return staff;
            }
        }
        return new Staff("NewComer",000,'M',"New Comer");
    }

    private void openFromDatabase()  {
        try {
            FileInputStream staffFile = new FileInputStream(staffFileName);
            ObjectInputStream staffIn = new ObjectInputStream(staffFile);

            this.staffList = (ArrayList<Staff>) staffIn.readObject();

            staffFile.close();
            staffIn.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    private void saveToDatabase() throws IOException {
        try {
            FileOutputStream staffFile = new FileOutputStream(staffFileName);
            ObjectOutputStream staffOut = new ObjectOutputStream(staffFile);

            staffOut.writeObject(staffList);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }
}