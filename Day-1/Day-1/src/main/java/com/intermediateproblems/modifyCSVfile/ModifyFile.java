package com.intermediateproblems.modifyCSVfile;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class ModifyFile {
    public static void main(String[] args) {
    try{
        //file path
        FileReader fr = new FileReader("C:\\Users\\sarve\\Desktop\\Week 5 pr\\Day-1\\src\\main\\java\\com\\intermediateproblems\\modifyCSVfile\\employee.csv");
        CSVReader csvr = new CSVReader(fr);

        //file path for storing updating data
        FileWriter fw = new FileWriter("C:\\Users\\sarve\\Desktop\\Week 5 pr\\Day-1\\src\\main\\java\\com\\intermediateproblems\\modifyCSVfile\\newemployee.csv");
        CSVWriter csvw = new CSVWriter(fw);

        String[] readLine; //store row
        String[] header = csvr.readNext(); //taking header
        csvw.writeNext(header); //writing header in new file once
        while((readLine = csvr.readNext())!= null){
            double salary = Double.parseDouble(readLine[3]); //parsing salary
            if(Objects.equals(readLine[2], "IT")){
                double newSalary = (salary*110)/100;
                readLine[3] = String.valueOf(newSalary); //updating salary of IT department employee

            }
            csvw.writeNext(readLine); //writing updated data into new CSV file
        }
        System.out.println("Successfully modify salary");
        csvw.close();
    }
    catch (IOException | CsvValidationException e){
        e.printStackTrace();
    }

    }
}
