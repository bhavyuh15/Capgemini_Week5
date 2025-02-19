package com.basicproblems.writedatatoacsvfile;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToCSVFile {
    //method for writing a data
    static void writeData(){
        try{
            FileWriter fr = new FileWriter("src/main/java/com/basicproblems/writedatatoacsvfile/employee.csv");
            CSVWriter csvw = new CSVWriter(fr);
            //creating data
            String[] header = {"ID","Name","Department","Salary"};
            String[] emp1 = {"101","Aman","Engineering","60000"};
            String[] emp2 = {"102","Yogesh","HR","50000"};
            String[] emp3 = {"103","Pradeep","Marketing","55000"};
            String[] emp4 = {"104", "Shivraj", "Sales", "40000"};
            String[] emp5 = {"105", "Sujal", "IT","60000"};
            //adding to file
            csvw.writeNext(header);
            csvw.writeNext(emp1);
            csvw.writeNext(emp2);
            csvw.writeNext(emp3);
            csvw.writeNext(emp4);
            csvw.writeNext(emp5);
            csvw.close();
            System.out.println("CSV file written successfully!");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        writeData(); //call writeData method
    }
}
