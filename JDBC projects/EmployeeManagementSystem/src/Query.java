public class Query {
    //CRUD operations
    static String insert = "INSERT INTO employee (id, name, salary) VALUES(?,?,?)"; //Create
    static String select = "SELECT * FROM employee"; //Read
    static String update = "UPDATE employee SET name = ? WHERE id = ?"; //Update
    static String delete = "DELETE FROM employee WHERE id = ?";  // Delete

}
