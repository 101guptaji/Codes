package javaBasics;

//A Java program to demonstrate working
//of a Class type object created by JVM
//to represent .class file in memory.
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Java code to demonstrate use
//of Class object created by JVM
public class ClassTypeObject {
	public static void main(String[] args)
    {
        Student s1 = new Student();

        // Getting hold of Class
        // object created by JVM.
       Class c1 = s1.getClass();
       
        // Printing type of object using c1.
       System.out.println(c1.getSimpleName());

        // getting all methods in an array
        Method[] methods = c1.getDeclaredMethods();
        for(Method m : methods) {
        	System.out.println(m.getName());
        }

        // getting all fields in an array
        Field[] fields = c1.getDeclaredFields();
        for(Field f : fields) {
        	System.out.println(f.getName());
        }
        
        //For every loaded “.class” file, only one object of the class is created. 
        Student s2 = new Student();
        // c2 will point to same object where c1 is pointing
        Class c2 = s2.getClass();
        System.out.println(c1==c2); // true
        
        // String class is loaded by bootstrap loader, and
        // bootstrap loader is not Java object, hence null
        System.out.println(String.class.getClassLoader());

        // ClassTypeObject class is loaded by Application loader
        System.out.println(ClassTypeObject.class.getClassLoader());
    }
}



//A sample class whose information
//is fetched above using its Class object.
class Student {
 private String name;
 private int roll_No;

 public String getName() { return name; }
 public void setName(String name) { this.name = name; }
 public int getRoll_no() { return roll_No; }
 public void setRoll_no(int roll_no)
 {
     this.roll_No = roll_no;
 }
}