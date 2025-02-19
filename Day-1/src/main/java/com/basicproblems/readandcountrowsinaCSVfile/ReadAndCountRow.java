package com.basicproblems.readandcountrowsinaCSVfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRow {
    public static void main(String[] args)  {
      try{
          //file path
          FileReader fr = new FileReader("C:\\Users\\sarve\\Desktop\\Week 5 pr\\Day-1\\src\\main\\java\\com\\basicproblems\\readandcountrowsinaCSVfile\\demofile.csv");
          //reading a file
          CSVReader csvr = new CSVReader(fr);

          // calculating number of record in a file
          int size = csvr.readAll().size();
          //print with include header row
          System.out.println(size-1);
      }catch (IOException | CsvException e){
          e.printStackTrace();
      }
    }
}
