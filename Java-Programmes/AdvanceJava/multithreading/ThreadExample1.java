package advanceJava.multithreading;

// Print "Hi" and "Guptaji" 10 times in alternate way
// class A extends Thread {
//     @Override
//     public void run() {
//         for (int i = 0; i < 5; i++) {
//             System.out.println("Hi");
//             try {
//                 Thread.sleep(10);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

// class B extends Thread {
//     @Override
//     public void run() {
//         for (int i = 0; i < 5; i++) {
//             System.out.println("Guptaji");
//             try {
//                 Thread.sleep(10);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }

public class ThreadExample1 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hi");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Guptaji");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // A t1 = new A();
        // B t2 = new B();

        t1.setPriority(Thread.MIN_PRIORITY);

        t1.start(); // create a new thread
        t2.start();
    }
}
