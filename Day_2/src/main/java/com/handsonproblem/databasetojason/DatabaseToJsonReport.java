package com.handsonproblem.databasetojason;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        // SQL query
        String query = "SELECT id, name, age, city FROM students";

        // Convert database records to JSON
        generateJsonReport(url, user, password, query, "report.json");
    }

    public static void generateJsonReport(String url, String user, String password, String query, String outputFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode(); // JSON Array

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Convert ResultSet into JSON
            while (rs.next()) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                jsonObject.put("id", rs.getInt("id"));
                jsonObject.put("name", rs.getString("name"));
                jsonObject.put("age", rs.getInt("age"));
                jsonObject.put("city", rs.getString("city"));
                jsonArray.add(jsonObject);
            }

            // Convert JSON array to a formatted string
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
            System.out.println(jsonOutput); // Print JSON

            // Write JSON to file
            try (FileWriter file = new FileWriter(outputFile)) {
                file.write(jsonOutput);
                System.out.println("JSON report saved as " + outputFile);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
