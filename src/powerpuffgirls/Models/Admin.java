package powerpuffgirls.Models;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Admin extends ORM {
    private static final String TABLE_NAME="Admin";
    private String NamaLengkap;
    private String Username;
    private String Password;
    private String Email;
    private String NoHP;
    private String TanggalLahir;

    public Admin(String namaLengkap, String username, String password, String email, String noHP, String tanggalLahir) {
        NamaLengkap = namaLengkap;
        Username = username;
        Password = password;
        Email = email;
        NoHP = noHP;
        TanggalLahir = tanggalLahir;
    }

    public static ArrayList<Admin> getAdmin(){
        ResultSet result = selectAll(TABLE_NAME);
        ArrayList<Admin> admin=new ArrayList<>();
        try {
            while (result.next()){
                String NamaLengkap= result.getString("NamaLengkap");
                String Username= result.getString("Username");
                String Password= result.getString("Password");
                String Email= result.getString("Email");
                String NoHP= result.getString("NoHP");
                String TanggalLahir= result.getString("TanggalLahir");
                Admin adminModel = new Admin(NamaLengkap,Username,Password,Email,NoHP,TanggalLahir);
                admin.add(adminModel);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return admin;
    }

//    public static boolean insertAdmin(String namaLengkap,String username,String password,String email,String noHP,String tanggalLahir){
//        Map<String,String> data= new HashMap<String, String>();
//        data.put("Nama_Lengkap","'Maya Cantik'");
//        data.put("Username","'maya oke'");
//        data.put("Password","'12345678'");
//        data.put("Email","'mayacantik123@gmail.com'");
//        data.put("NoHP","'08224564576'");
//        data.put("TanggalLahir","'06 November 2001'");
//        boolean status= insert(TABLE_NAME,data);
//        return status;
//    }

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
        Username = username;
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
