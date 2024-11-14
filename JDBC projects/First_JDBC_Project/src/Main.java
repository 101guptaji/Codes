public class Main {
    public static void main(String[] args) {

        SQLOperations s = new SQLOperations();
        String dbName = "school";

        //s.createDb(dbName);

        String tableName = "student";
        //s.createTable(dbName, tableName);

        //CRUD operations
        //s.insertData(dbName, tableName);

        //s.readData(dbName, tableName);

        //s.updateData(dbName, tableName);

        s.deleteData(dbName, tableName);
    }
}
