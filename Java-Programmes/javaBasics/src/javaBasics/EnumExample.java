package javaBasics;

enum Color{
	 // This will call enum constructor with one String argument
    RED("STOP"), 
    GREEN("GO"), 
    ORANGE("SLOW DOWN");

    // declaring private variable for getting values
    private String action;

    // getter method
    public String getAction()
    {
        return this.action;
    }

    // enum constructor - cannot be public or protected
    private Color(String action)
    {
        this.action = action;
    }
}
public class EnumExample {
	
	public static void main(String[] args) {
		//values() method -> return an  array of all values present inside the enum.
		Color[] colors = Color.values();
		for(Color c : colors) {
			// Calling ordinal() to find index of color.
			System.out.println("Index of "+c+": "+c.ordinal());
		}
		// Using valueOf(). Returns an object of Color with given constant.
		System.out.println(Color.valueOf("GREEN"));
		
		Color c1 = Color.RED;
		System.out.println("Color: "+c1.name()+", action: "+c1.getAction());
	}
}
