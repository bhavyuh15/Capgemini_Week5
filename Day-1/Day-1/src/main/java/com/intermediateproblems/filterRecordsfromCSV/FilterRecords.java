package com.intermediateproblems.filterRecordsfromCSV;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FilterRecords {
    public static void main(String[] args) throws Exception {
      try{
          //file path
          FileReader fr = new FileReader("C:\\Users\\sarve\\Desktop\\Week 5 pr\\Day-1\\src\\main\\java\\com\\intermediateproblems\\filterRecordsfromCSV\\student.csv");
          CSVReader csvr = new CSVReader(fr);

          String[] nextLine; //Array for store one line

          //printing header
          System.out.println(Arrays.toString(csvr.readNext()));
          while((nextLine = csvr.readNext()) != null){
              String id = nextLine[0];
              String name = nextLine[1];
              String age = nextLine[2];
              double marks = Double.parseDouble(nextLine[3]); //convert string to double
              if(marks > 80){
                  System.out.println("ID: "+ id+", Name: "+ name + ", age: "+ age+ ", Mark: "+ marks);
              }
          }
      }catch (IOException e){
          e.printStackTrace();
      }
    }
}
