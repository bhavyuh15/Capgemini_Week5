package com.intermediateproblems.sortCSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        try {
            // path to the CSV file
            FileReader fr = new FileReader("C:\\Users\\sarve\\Desktop\\Week 5 pr\\Day-1\\src\\main\\java\\com\\intermediateproblems\\sortCSV\\employee.csv");

            CSVReader csvr = new CSVReader(fr);

            String[] nextLine; // Array to hold each row's data

            // Skip the header row
            System.out.println(Arrays.toString(csvr.readNext()));

            // List to store employee records
            List<String[]> employeeList = new ArrayList<>();

            // Read all employee records from the CSV file
            while ((nextLine = csvr.readNext()) != null) {
                employeeList.add(nextLine);
            }

            // Define a comparator to sort employees based on salary in descending order
            Comparator<String[]> com = new Comparator<>() {
                @Override
                public int compare(String[] emp1, String[] emp2) {
                    // Convert salary (4th column) to Double and compare
                    return Double.compare(Double.parseDouble(emp2[3]), Double.parseDouble(emp1[3]));
                }
            };

            // Sort the employee list using the comparator
            employeeList.sort(com);

            // Print the top 5 highest-paid employees
            System.out.println("Top 5 Highest Paid Employees:");
            for (int i = 0; i < Math.min(5, employeeList.size()); i++) {
                String[] emp = employeeList.get(i);
                System.out.println(emp[0] + "   " + emp[1] + "   " + emp[2] + "    " + emp[3]);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
