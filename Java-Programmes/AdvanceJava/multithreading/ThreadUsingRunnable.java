package multithreading;

public class ThreadUsingRunnable implements Runnable{

    @Override
    public void run() {
        try{
            System.out.println("Thread "+Thread.currentThread().threadId()+" is runng using Runnable.");
        }        
        catch(Exception e){
            System.out.println("An exception is caught");
        }
    }
    
}
