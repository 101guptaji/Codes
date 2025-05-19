package advanceJava;

public class InterfaceExam{

    int a = 5;

    Test obj = () -> {

        System.out.println(this.a);
    };

    public static void main(String[] args) {

        InterfaceExam ob = new InterfaceExam();

        ob.obj.run();

    }
}

interface Test {

    public void run();

}