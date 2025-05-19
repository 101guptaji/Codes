package advanceJava.multithreading;

class Counter{
    int count; // Shared resource

    // Not thread safe
    // public void increament(){
    //     count++;
    // }

    // thread safe using synchronized 
    public synchronized void increament(){
        count++;
    }
}

public class ThreadSafety1 {
    public static void main(String[] args) {

        Counter cnt = new Counter();

        Runnable rn1 = () -> {
            for (int i = 0; i < 10000; i++) {
                cnt.increament();
            }
        };

        Runnable rn2 = () -> {
            for (int i = 0; i < 10000; i++) {
                cnt.increament();
            }
        };

        Thread t1 = new Thread(rn1);

        Thread t2 = new Thread(rn2);

        // create a new thread for t1 and t2
        t1.start(); 
        t2.start();

        // Main thread will wait for completion of Thread t1 and t2
        try {
            t1.join();
            t2.join();
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(cnt.count);
    }
}
