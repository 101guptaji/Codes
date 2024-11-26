package multithreading;

public class ThreadDemo {
    public static void main(String[] args) {
        ThreadUsingThreadClass th = new ThreadUsingThreadClass();
        th.start();
        
        Thread thRun = new Thread(new ThreadUsingRunnable());
        thRun.start();
        
    }
}
