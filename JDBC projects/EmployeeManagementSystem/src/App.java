import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nEmployee Management");
            System.out.println("1. Create or Insert \t 2. Read \t 3. Update \t 4. Delete");

            int choice = sc.nextInt();
            if(choice<1 || choice > 4) break;

            switch (choice) {
                case 1:
                    System.out.println("Enter id, name, salary");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String name = sc.nextLine();
                    int salary = sc.nextInt();
                    sc.nextLine();

                    EmployeeSQL.createEmployee(new Employee(id, name, salary));
                    break;
                case 2: 
                    ArrayList<Employee> empList = EmployeeSQL.readAllEmployee();
                    for(Employee emp : empList){
                        System.out.println(emp);
                    }
                    break;
                case 3:
                    System.out.println("Enter id, name");
                    id = sc.nextInt();
                    sc.nextLine();
                    name = sc.nextLine();

                    EmployeeSQL.updateEmployee(new Employee(id, name, 0));
                    break;
                case 4:
                    System.out.println("Enter Id to delete");
                    id = sc.nextInt();
                    sc.nextLine();

                    EmployeeSQL.deleteEmployee(id);
                    break;
            }
        }
        sc.close();
    }
}
