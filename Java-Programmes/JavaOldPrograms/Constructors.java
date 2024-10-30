class Person {
    private String name;
    private int age;
    
    public Person() {
        name="Nanu";
        
        System.out.println("Default name: " +name);
    }
    
    public Person(String name) {
        this.name=name;
        
        System.out.println("Second constructor running");
        
    }
    
    public Person(String name, int age) {
        
        System.out.println("Third constructor running");
        this.name = name;
        this.age = age;
    }
}

public class Constructors {
    public static void main(String[] args) {
        new Person();
        new Person("Arnav");
        new Person("Sanu", 13);
        
    }

}