package dsaProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * WardrobeSpecification.java
 * 
 * This program reads a specification of wardrobe components and their
 * conversions,
 * then calculates the total number of base components required to build the
 * wardrobe.
 * 
 * Input format:
 * - First line: Comma-separated list of components in order from base to top.
 * - Subsequent lines: Conversion rules in the format "Component is X
 * TargetComponent".
 * 
 * Example input:
 * Shelve,Draw,Rack,Wardrobe
 * Shelve is 2 Draw
 * Rack is 3 Shelve
 * Wardrobe is 36 Draw
 * 
 * Example output:
 * 1Wardrobe equals 6Rack equals 18Shelve equals 36Draw
 */

public class WardrobeSpecification {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read component order
        String[] components = br.readLine().split(",");

        // Parse conversion map
        Map<String, ComponentConversion> conversionMap = new HashMap<>();
        for (int i = 0; i < components.length - 1; i++) {
            String[] parts = br.readLine().trim().split(" "); // e.g., "Shelve is 2 Draw"
            if (parts.length == 4) {
                String from = parts[0];
                int multiplier = Integer.parseInt(parts[2]);
                String to = parts[3];
                // System.out.println("Adding conversion: " + from + " is " + multiplier + " " + to);
                conversionMap.put(from, new ComponentConversion(multiplier, to));
            }
        }

        // Start from the highest-level component
        String current = components[components.length - 1];
        int quantity = 1;
        StringBuilder result = new StringBuilder();
        result.append(quantity).append(current);

        // Traverse and convert down to base component
        while (conversionMap.containsKey(current)) {
            ComponentConversion conversion = conversionMap.get(current);
            quantity *= conversion.multiplier;
            current = conversion.target;
            result.append(" equals ").append(quantity).append(current);
        }
        System.out.println(result.toString());
    }

    static class ComponentConversion {
        int multiplier;
        String target;

        ComponentConversion(int multiplier, String tar) {
            this.multiplier = multiplier;
            this.target = tar;
        }
    }
}
