//Setting values for object using "this" method
class person {
    private String name;
    private int age;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setInfo(String name, int age) {
        setName(name);
        setAge(age);
    }
}

public class classWithSetter {

    public static void main(String[] args) {
    
        person p1 = new person();
    
        p1.setName("Hanni");
        p1.setAge(20);
        
        System.out.println("Name: "+p1.getName());
        System.out.println("Age: "+p1.getAge());

        person p2=new person();
        p2.setInfo("Sonu sharma", 15);
        System.out.println("Name: "+p2.getName());
        System.out.println("Age: "+p2.getAge());
    }

}