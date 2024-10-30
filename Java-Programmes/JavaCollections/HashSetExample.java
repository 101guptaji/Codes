import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        //adding elements 
        hs.add(5);
        hs.add(7);
        hs.add(3);
        hs.add(1);
        hs.add(5); //duplicates are allowed

        System.out.println("Size of set "+hs.size());

        //searching 
        if(hs.contains(3)){
            System.out.println("contain 3");
        }
        else{
            System.out.println("does not contain 3");
        }

        //delete
        hs.remove(3);
        if(hs.contains(3)){
            System.out.println("contain 3");
        }
        else{
            System.out.println("does not contain 3");
        }

        //printing
        System.out.println(hs);
        
        //iterator
        Iterator it = hs.iterator();
        System.out.println("Printing using iterator");
        while(it.hasNext()){
            System.out.print(it.next()+", ");
        }
        System.out.println();

        


    }
}
