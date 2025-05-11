import java.util.ArrayList;
import java.util.HashMap;
public class Generic {
    public static void main(String[] args) {

        //old java method
        ArrayList list=new ArrayList();

        list.add("Papaya");
        list.add("Orange");

        String fruit=(String)list.get(0);
        System.out.println(fruit);

        //modern method
        ArrayList<String>list2=new ArrayList<String>();
        list2.add("Cow");
        list2.add("Goat");
        
        String Animal=list2.get(1);
        System.out.println(Animal);

        list2.add(1, "Lion");

        Animal=list2.get(1);
        System.out.println(Animal);

        HashMap<String, Integer>hash=new HashMap<String, Integer>();
        
        //////////// Java 7 style /////////////////////////////////
        //error: Animal cannot be resolved to a type
        //ArrayList<Animal> someList = new ArrayList<>();

    }
}
