package controller;

import entity.Order;
import entity.Table;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static helperFunction.FormatAsTable.formatAsTable;

public class TableController {
    private String tableFileName = "tableData.db";
    private ArrayList<Table> tableList;

    Scanner sc = new Scanner(System.in);

    public TableController(){
        openFromDatabase();
    }

    public Table getAvailTable(){
        List<List<String>> rows = new ArrayList<>();
        List<String> header = Arrays.asList("Table Number", "Table Size");
        rows.add(header);
        for (Table table : tableList){
            if (table.isVacant()){
                List<String> body = Arrays.asList(String.valueOf(table.getTableNumber()),String.valueOf(table.getSize()));
                rows.add(body);
            }
        }
        System.out.println(formatAsTable(rows));
        int choice = sc.nextInt();
        sc.nextLine();
        for(Table table : tableList){
            if (table.getTableNumber()==choice){
                table.setVacant(false);
                saveToDatabase();
                return table;
            }
        }
        System.out.println("Please enter a valid table number");
        return getAvailTable();
    }

    private void openFromDatabase()  {
        try {
//            Deserialize table file
            FileInputStream tableFile = new FileInputStream(tableFileName);
            ObjectInputStream tableIn = new ObjectInputStream(tableFile);

            this.tableList = (ArrayList<Table>) tableIn.readObject();

            tableFile.close();
            tableIn.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught hahaha");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    private void saveToDatabase() {
        try {
            FileOutputStream tableFile = new FileOutputStream(tableFileName);
            ObjectOutputStream tableOut = new ObjectOutputStream(tableFile);

            tableOut.writeObject(tableList);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }
}
