package com.basicproblems.readCSVfileprintdata;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;


public class ReadCSVFilePrintData {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\sarve\\Desktop\\Week 5 pr\\Day-1\\src\\main\\java\\com\\basicproblems\\readCSVfileprintdata\\stutdentdetails.csv";

        try {
            // Create a FileReader object to read the file
            FileReader fr = new FileReader(filePath);

            // Create a CSVReader object to parse CSV data
            CSVReader reader = new CSVReader(fr);

            // Array to store each row read from the CSV file
            String[] nextLine;

            reader.readNext();
            // Read CSV file line by line
            while ((nextLine = reader.readNext()) != null) {
                // Print each column of the CSV row
                System.out.println("ID: " + nextLine[0] +
                        ", Name: " + nextLine[1] +
                        ", Age: " + nextLine[2] +
                        ", Marks: " + nextLine[3]);
            }


            reader.close();
            fr.close();

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
