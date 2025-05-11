package abstractExample;

public abstract class Machine {
   private int id=5;

   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }
    public abstract void start();
    public abstract void doStuff();
    //Abstract method can not define in aabstract class
    /*public abstract void shutdown(){
        System.out.println("Machine stopped");
    }
    */
    public void run() {
        start();
        doStuff();
        shutdown();

    }   
    public void shutdown(){
        System.out.println("Machine stopped");
    }
}
