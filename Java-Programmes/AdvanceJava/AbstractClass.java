package advanceJava;

abstract class Vehicle{

    abstract void speed();

    abstract void type();

    void general(){
        System.out.println("This is a vehicle");
    }
}

abstract class Car extends Vehicle{

    @Override
    void type() {
        System.out.println("THis is a Car");
    }

}

class WagonR extends Car{

    @Override
    void speed() {
        System.out.println("WagonR can run upto a speed of 80Km/hr");
    }
    
}

public class AbstractClass {
    public static void main(String[] args) {
        
        // Vehicle vh = new vehicle(); // error: can'not create an object of abstract class
        // Vehicle car = new Car(); // error: can'not create an object of abstract class

        Vehicle wagonR = new WagonR();
        wagonR.general();
        wagonR.type();
        wagonR.speed();
    }
}
