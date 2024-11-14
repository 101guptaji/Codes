import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SQLOperations {

    public void createDb(String databaseName){
        try {
            //1. load driver
            String url = "jdbc:mysql://localhost:3306/";

            String userName = "root";
            String password = "8561903090";
    
            //2. establish connection
            Connection conn = DriverManager.getConnection(url,userName, password);
    
            //3. create statement
            Statement statement = conn.createStatement();

            //4. Create and excute query in statement.
            String sql = "CREATE DATABASE IF NOT EXISTS " + databaseName;
            statement.execute(sql);

            //5. close the connection.
            conn.close();

            JOptionPane.showMessageDialog(null, databaseName + " Database has been created successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void  createTable(String dbName, String tableName){
        try{
            String  url = "jdbc:mysql://localhost:3306/";

            String userName = "root";
            String password = "8561903090";
            
            Connection conn = DriverManager.getConnection(url+dbName, userName, password);

            Statement stmt = conn.createStatement();

            String query = "CREATE TABLE "+tableName+" (id INT PRIMARY KEY, name VARCHAR(50), email VARCHAR(50))";
            stmt.execute(query);

             conn.close();
            
            System.out.println("Table created successfully");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void insertData(String dbName, String tableName) {
        try{
            String  url = "jdbc:mysql://localhost:3306/";

            String userName = "root";
            String password = "8561903090";
            
            Connection conn = DriverManager.getConnection(url+dbName, userName, password);

            String query = "INSERT INTO "+tableName+" (id, name, email) VALUES(?,?,?)";
            PreparedStatement pdstmt = conn.prepareStatement(query);
            pdstmt.setInt(1, 3);
            pdstmt.setString(2, "Jatin");
            pdstmt.setString(3, "jatin3@gmail.com");

            pdstmt.execute();

            conn.close();
            
            System.out.println("Data inserted successfully");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void readData(String dbName, String tableName) {
        try{
            String  url = "jdbc:mysql://localhost:3306/";

            String userName = "root";
            String password = "8561903090";
            
            Connection conn = DriverManager.getConnection(url+dbName, userName, password);

            Statement stmt = conn.createStatement();

            String query = "SELECT * FROM "+tableName;
            ResultSet data = stmt.executeQuery(query);
                        
            System.out.println("Reading data:");
            while(data.next()){
                System.out.println("id = "+data.getInt(1));
                System.out.println("name = "+data.getString(2));
                System.out.println("email = "+data.getString(3));
            }

            stmt.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateData(String dbName, String tableName) {
        try{
            String  url = "jdbc:mysql://localhost:3306/";

            String userName = "root";
            String password = "8561903090";
            
            Connection conn = DriverManager.getConnection(url+dbName, userName, password);

            Statement stmt = conn.createStatement();

            String query = "UPDATE "+tableName+" SET email = 'HariNew2@gmail.com' WHERE id = 2";
            int rowEffected = stmt.executeUpdate(query);

            stmt.close();
            
            System.out.println(rowEffected+" rows updated");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteData(String dbName, String tableName) {
        try{
            String  url = "jdbc:mysql://localhost:3306/";

            String userName = "root";
            String password = "8561903090";
            
            Connection conn = DriverManager.getConnection(url+dbName, userName, password);

            Statement stmt = conn.createStatement();

            String query = "DELETE FROM "+tableName+" WHERE id = 3";
            int rowEffected = stmt.executeUpdate(query);

            stmt.close();
            
            System.out.println(rowEffected+" rows deleted");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
