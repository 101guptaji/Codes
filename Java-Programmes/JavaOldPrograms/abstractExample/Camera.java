package abstractExample;

class Camera extends Machine{
   @Override
    public void start() {
        System.out.println("Starting camera.");
    }

    @Override
    public void doStuff() {
        System.out.println("Taking a photo");
        
    } 

    @Override
    public void shutdown() {
        System.out.println("Camera stopped");
        
    }
}
