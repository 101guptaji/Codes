class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

class Camera extends Engine {
    public void start() {
        System.out.println("Camera started.");
    }
    
    public void snap() {
        System.out.println("Photo taken.");
    }
}


public class UppercastLowercast {
    public static void main(String[] args) {

        Engine eng1 = new Engine();
        Camera camera1 = new Camera();
        
        eng1.start();
        camera1.start();
        camera1.snap();
        
        // Upcasting 
        Engine eng2 = camera1;
        eng2.start();
        // error: eng2.snap();

        // Downcasting
        Engine eng3 = new Camera();
        Camera camera2 = (Camera)eng3;
        camera2.start();
        camera2.snap();
        
        // Doesn't work --- runtime error.
        //class Engine cannot be cast to class Camera
        Engine eng4 = new Engine();
        //Camera camera3 = (Camera)eng4;
        //camera3.start();
        //camera3.snap();
    }

}
