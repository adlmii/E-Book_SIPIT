package Config;

import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class koneksi {
    private static Connection conn;
    
    public static Connection getConnection(){
        if (conn == null) {
            try {
               String url = "jdbc:mysql://localhost:3306/db_sipit"; 
               String user = "root";
               String pass = "";
               DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
               conn = (Connection) DriverManager.getConnection(url,user,pass);
            } catch (Exception e) {
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return conn;
    }
}
