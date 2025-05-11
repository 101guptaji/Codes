class Thing {
    public final static int LUCKY_NUMBER = 7; //final value can not reassign.
    
    public String name;
    public static String description; //Class variable. Oject can not have its own seperate copy.
    
    public static int count = 0;
    
    public int id;
    
    public Thing() {
        
        id = count;
        
        count++;
    }
    
    public void showName() {
        System.out.println("Object id: " + id + ", " + description + ": " + name);
    }
    
    public static void showInfo() {
        System.out.println(description);
    }
}


public class StaticFinal {

    public static void main(String[] args) {
        
        Thing.description = "I am a thing";
        
        Thing.showInfo();
        
        System.out.println("Before creating objects, count is: " + Thing.count);
        
        Thing thing1 = new Thing();
        Thing thing2 = new Thing();
        
        System.out.println("After creating objects, count is: " + Thing.count);
        
        thing1.name = "Bob";
        thing2.name = "Sue";
        
        thing1.showName();
        thing2.description="You am fine";
        thing2.showName();
        thing1.showInfo();
        
        //Thing.LUCKY_NUMBER=13; 
        
        System.out.println(Thing.LUCKY_NUMBER);
    }

}