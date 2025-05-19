package advanceJava;

class  A {
    int age = 15;

    public void show(){
        System.out.println("You are in A and You are "+age+" years old");
    }   

    // inner class
    class B{
        // int age = 50;

        public void child(){
            System.out.println("You are in B and You are "+age+" years old");
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
        A a = new A();
        a.show();

        // accesing inner class
        // A.B b = a.new B();

        A.B b = new A().new B();
        b.child();
    }
}
