public class Employee {
    private int id;
    private String name;
    private int salary;

    Employee(int id, String name, int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getSalary(){
        return this.salary;
    }

    @Override
    public String toString(){
        return "ID = "+id+", Name = "+name+", Salary = "+salary;
    }
}
