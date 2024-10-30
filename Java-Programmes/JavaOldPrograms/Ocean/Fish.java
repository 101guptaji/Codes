package Ocean;

public class Fish {
   public String toString() //overriding the toString() method  
    {
        
        StringBuilder sb = new StringBuilder("");
        sb.append("hello").append(": ").append("Fish");
        
        return sb.toString();
        
    }
}
