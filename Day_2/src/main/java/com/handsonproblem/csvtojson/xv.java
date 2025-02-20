package com.handsonproblem.csvtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        String csvFilePath = "data.csv"; // Change this to your CSV file path
        convertCsvToJson(csvFilePath);
    }

    public static void convertCsvToJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode(); // Holds multiple JSON objects

        try (CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : csvParser) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                record.toMap().forEach(jsonObject::put); // Convert each row to JSON
                jsonArray.add(jsonObject);
            }

            // Convert JSON array to a formatted string
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
            System.out.println(jsonOutput);

            // Save JSON to file
            objectMapper.writeValue(new File("output.json"), jsonArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

