// Source code is decompiled from a .class file using FernFlower decompiler.
import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
   public static Connection conn = null;

   public DB() {
   }

   public static Connection connect() {
      try {
         String var0 = "jdbc:mysql://localhost:3306/company";
         String var1 = "root";
         String var2 = "8561903090";
         conn = DriverManager.getConnection(var0, var1, var2);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      return conn;
   }
}
