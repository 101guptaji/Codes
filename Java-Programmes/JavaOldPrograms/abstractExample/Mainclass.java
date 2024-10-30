//Abstract classes allow you to define the parent class of a new hierarchy without having to worry about the user actually instantiating the parent.
package abstractExample;

public class Mainclass {
    public static void main(String[] args) {
        Camera camera1=new Camera();
        System.out.println( camera1.getId());

        Cars car1=new Cars();
        car1.setId(13);
        System.out.println( car1.getId());

        //Abstract class can not call.
        //Machine mach1=new Machine();
        //System.out.println(mach1.getId());

        car1.start();

        car1.run();

        camera1.run();


    }
}
