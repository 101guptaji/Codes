package interfaces;
public class App {
    public static void main(String[] args) 
    {
        Machine m1=new Machine();
        m1.start();
        System.out.println(m1);
        Person p1= new Person("Anshu");
        p1.greet();

        Info info1= new Machine();
        info1.showInfo();

        Info info2= p1;
        info2.showInfo();

        output(m1);
        output(p1);
    }
        private static void output(Info info3)
        {
            info3.showInfo();
        }
    
}
