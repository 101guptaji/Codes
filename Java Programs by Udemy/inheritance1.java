class machines {
    
    protected String name = "Machine Type 1";
    
    public void start() {
        System.out.println("Machine started.");
    }
    
    public void stop() { 
        System.out.println("Machine stopped.");
    }
}
class car extends machines {

    
    public void start() {
        System.out.println("Car started");
    }

    public void wipeWindShield() {
        System.out.println("Wiping windshield");
    }
    
    public void showInfo() {
        System.out.println("Car name: " + name);
    }
}

public class inheritance1 {

    public static void main(String[] args) {
        machines mach1 = new machines();
        
        mach1.start();
        mach1.stop();
        
        car car1 = new car();
        
        car1.start();
        car1.wipeWindShield();
        car1.showInfo();
        car1.stop();
        
        
    }

}

 