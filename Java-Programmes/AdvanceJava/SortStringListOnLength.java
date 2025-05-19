package advanceJava;

import java.util.*;

public class SortStringListOnLength {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Himanshu");
        list.add("Surender");
        list.add("Bhanu");
        list.add("Anu");
        list.add("Bhavesh");

        // Collections.sort(list, new Comparator<String>() {

        //     @Override
        //     public int compare(String o1, String o2) {
        //        if(o1.length()>o2.length())
        //             return 1;
        //         else
        //             return -1;
        //     }
            
        // });
        Collections.sort(list, (o1, o2) -> o1.length()>o2.length() ? 1 : -1);

        System.out.println(list);
    }   
}
