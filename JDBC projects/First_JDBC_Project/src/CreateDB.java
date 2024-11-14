import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CreateDB {
    
    public static void main(String[] args) throws Exception {
        try {
            //1. load driver
            //jdbc = driver name
            //mysql = server name
            //localhost = address
            //3306 = port no.
            String url = "jdbc:mysql://localhost:3306/";

            String databaseName = "school";
            String userName = "root";
            String password = "8561903090";
    
            //2. establish connection
            Connection conn = DriverManager.getConnection(url,userName, password);
    
            //3. create statement
            Statement statement = conn.createStatement();

            //4. Create and excute query in statement.
            String sql = "CREATE DATABASE " + databaseName;
            statement.executeUpdate(sql);

            //5. close the connection.
            conn.close();

            JOptionPane.showMessageDialog(null, databaseName + " Database has been created successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
