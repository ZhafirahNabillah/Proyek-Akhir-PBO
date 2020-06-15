package powerpuffgirls.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User extends ORM {



    private static final String TABLE_NAME="User";
    private static int IdUser;
    private static String NamaLengkap;
    private static String Username;
    private static String Password;
    private static String Email;
    private static String NoHP;
    private static String TanggalLahir;

    public User(int idUser, String namaLengkap, String username, String password, String email, String noHP, String tanggalLahir) {
        IdUser = idUser  ;
        NamaLengkap = namaLengkap;
        Username = username;
        Password = password;
        Email = email;
        NoHP = noHP;
        TanggalLahir = tanggalLahir;
    }

    public static ArrayList<User> getUser(){
        ResultSet result = selectAll(TABLE_NAME);
        ArrayList<User> users=new ArrayList<>();
        try {
            while (result.next()){
                int IdUser= result.getInt("IdUser");
                String NamaLengkap= result.getString("NamaLengkap");
                String Username= result.getString("Username");
                String Password= result.getString("Password");
                String Email= result.getString("Email");
                String NoHP= result.getString("NoHP");
                String TanggalLahir= result.getString("TanggalLahir");
                User usersModel = new User(IdUser,NamaLengkap,Username,Password,Email,NoHP,TanggalLahir);
                users.add(usersModel);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return users;
    }

//    public static int getLoginValue(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet, String username, String password) {
//        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
//        try {
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, username);
//            preparedStatement.setString(2, password);
//
//            resultSet = preparedStatement.executeQuery();
//
//            if (!resultSet.next()) {
//                return 0;
//            } else {
//                return resultSet.getInt("IdUser");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return 0;
//    }

    public static boolean insertUser(String namaLengkap,String username,String password,String email,String noHP,String tanggalLahir){
        Map<String,String> data= new HashMap<String, String>();
        data.put("NamaLengkap","'"+ namaLengkap +"'");
        data.put("Username","'"+username+"'");
        data.put("Password","'"+password+"'");
        data.put("Email","'"+email+"'");
        data.put("NoHP","'"+noHP+"'");
        data.put("TanggalLahir","'"+tanggalLahir+"'");
        boolean status= insert(TABLE_NAME,data);
        return status;
    }

    public String getNamaLengkap() {
        return NamaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        NamaLengkap = namaLengkap;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        User.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNoHP() {
        return NoHP;
    }

    public void setNoHP(String noHP) {
        NoHP = noHP;
    }

    public String getTanggalLahir() {
        return TanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        TanggalLahir = tanggalLahir;
    }
}
