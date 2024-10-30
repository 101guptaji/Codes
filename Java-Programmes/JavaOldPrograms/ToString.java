class Frog {
    
    private int id;
    private String name;
    
    public Frog(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //if you will not write toString Method, java will print hashcode for the object.
    public String toString() //overriding the toString() method  
    {
        
        //return String.format("%d: %s", id, name);
        
        
        StringBuilder sb = new StringBuilder("");
        sb.append(id).append(": ").append(name);
        
        return sb.toString();
        
    }
}
//If you print any object, java compiler internally invokes the toString() method on the object. So overriding the toString() method, returns the desired output/
public class ToString {

    public static void main(String[] args) {
        Frog frog1 = new Frog(7, "Freddy");
        Frog frog2 = new Frog(5, "Roger");
        
        System.out.println(frog1);
        System.out.println(frog2);
    }
}