package advanceJava;

// Anonymous Inner class that defines inside method/constructor argument
public class AnonymousClass2 {
    public static void main(String[] args) {
        Thread th = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("This thread: "+Thread.currentThread().getName()+" created  using Anonymous class");
            }
            
        });

        th.start();

        System.out.println("Main thread name: "+Thread.currentThread().getName());
    }
}
