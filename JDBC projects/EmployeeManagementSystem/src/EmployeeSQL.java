import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeSQL {
    //Insertion
    public static void createEmployee(Employee emp) throws SQLException{
        Connection conn = DB.connect();

        String query = Query.insert;
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, emp.getId()); //id
        pst.setString(2, emp.getName()); //name
        pst.setInt(3, emp.getSalary()); //salary

        System.out.println("\n pst = "+pst+"\n");
        int rows = pst.executeUpdate();
        System.out.println(rows+" rows inserted");

        pst.close();
    }

    //View data
    public static ArrayList<Employee> readAllEmployee() throws SQLException{
        Connection conn = DB.connect();

        String query = Query.select;
        PreparedStatement pst = conn.prepareStatement(query);

        ResultSet data = pst.executeQuery();
        
        ArrayList<Employee> empList = new ArrayList<>();
        while(data.next()){
            int id = data.getInt(1);
            String name = data.getString(2);
            int salary = data.getInt(3);
            empList.add(new Employee(id, name, salary));
        }

        pst.close();

        return empList;
    }

    //Update
    public static void updateEmployee(Employee emp) throws SQLException{
        Connection conn = DB.connect();

        String query = Query.update;
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(2, emp.getId()); //id
        pst.setString(1, emp.getName()); //name

        int rows = pst.executeUpdate();
        System.out.println(rows+" rows updated");

        pst.close();
    }

    //delete
     public static void deleteEmployee(int id) throws SQLException{
        Connection conn = DB.connect();

        String query = Query.delete;
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id); //id

        int rows = pst.executeUpdate();
        System.out.println(rows+" rows deleted");

        pst.close();
    }
}
