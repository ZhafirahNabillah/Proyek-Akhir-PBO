package powerpuffgirls.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String USERNAME="root";
    private static final String PASSWORD="";

    public static Connection connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = String.format("jdbc:mysql://localhost/powerpuffgirls?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            Connection con = DriverManager.getConnection(url, USERNAME, PASSWORD);
            return con;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Class tidak ditemukan");
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Koneksi Database gagal");
            return null;
        }
    }
}
