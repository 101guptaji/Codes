package interfaces;

public class Machine implements Info{
    public int id=7;
    void start()
    {
        System.out.println("Machine started");
    }

    @Override
    public String toString() {
        return "Machine id: "+id;
    }

    @Override
    public void showInfo() {
        System.out.println("Machine info ");

    }
   
}
