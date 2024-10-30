package abstractExample;

class Cars extends Machine{

    @Override
    public void start() {
        System.out.println("Car started");

    }

    @Override
    public void doStuff() {
        System.out.println("Car is driving");

    }
    
}
