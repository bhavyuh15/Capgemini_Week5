package com.handsonproblem.readkeysvalues;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonKeysValues {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            JsonNode rootNode = objectMapper.readTree(new File("data.json"));

            // Print all keys and values
            printJsonKeysAndValues(rootNode, "");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Recursive method to print keys and values
    public static void printJsonKeysAndValues(JsonNode node, String parentKey) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJsonKeysAndValues(field.getValue(), parentKey + field.getKey() + ".");
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJsonKeysAndValues(node.get(i), parentKey + "[" + i + "].");
            }
        } else {
            // Print key-value pair
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " : " + node.asText());
        }
    }
}
