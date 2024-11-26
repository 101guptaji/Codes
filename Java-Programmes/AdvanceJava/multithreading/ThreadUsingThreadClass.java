package multithreading;

public class ThreadUsingThreadClass extends  Thread{
    @Override
    public void  run(){
        try{
            System.out.println("Thread "+Thread.currentThread().threadId()+" is runng using thread class.");
        }        
        catch(Exception e){
            System.out.println("An exception is caught");
        }
    }
}
