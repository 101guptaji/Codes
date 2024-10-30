/*
 * HashMap are unordered map.
 * key should be unique but value can be duplicate
 */

import  java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        //creating HashMap
        HashMap<String, Integer> map = new HashMap<>();

        //Insertion
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

        //printing
        System.out.println(map);

        //updating
        map.put("China", 180);
        //printing method 2
        for(String  key : map.keySet()){
            System.out.println(key+": "+map.get(key));
        }

        //Searching
        if(map.containsKey("China")) {
            System.out.println("China is present in the map");
        } 
        else {
            System.out.println("China is not present in the map");
        }

        System.out.println("Population of China "+map.get("China")); //key exists
        System.out.println("Population of Indonesia "+map.get("Indonesia")); //key doesn't exist

        //removing
        map.remove("China");
        System.out.println("Map after removing China\n"+map);

    }
}
