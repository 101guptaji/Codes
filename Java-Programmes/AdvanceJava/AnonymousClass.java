package advanceJava;

abstract class Demo {

    public abstract void show();
}

public class AnonymousClass {
    public static void main(String[] args) {
        
       Demo demo = new Demo() {
            public void show() {
                System.out.println("It is Anonymous class which Override show method.");
            }
        };

        demo.show();
    }
}
