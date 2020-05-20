package sample.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection con = null;
//    public static final String DBMS = "mysql";
//    public static final String HOST = "128.199.196.208";
//    public static final String USERNAME = "PuffGirls";
//    public static final String PASSWORD = "proyekakhirpbo2";
//    public static final String DATABASE = "PowerPuffGirls";

    public static Connection connect() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/powerpuffgirls","root","root")
                return con;
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
