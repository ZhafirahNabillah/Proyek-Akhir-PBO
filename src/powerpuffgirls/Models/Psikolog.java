package powerpuffgirls.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Psikolog {
    public Psikolog(String id, String nama, String username, String password, String email,String nohp, String tanggal){
        this.id = new SimpleStringProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);
        this.nohp = new SimpleStringProperty(nohp);
        this.tanggal = new SimpleStringProperty(tanggal);
    }
    public static String idPsi;
    public static String namaLengkap;
    public static String usrname;
    public static String pass;
    public static String mail;
    public static String noHandphone;
    public static String tglLahir;
    public static String nm;
    public static String handphone;

    private StringProperty id;
    private StringProperty nama;
    private StringProperty username;
    private StringProperty password;
    private StringProperty email;
    private StringProperty nohp;
    private StringProperty tanggal;

    public static String getIdPsi() {
        return idPsi;
    }

    public static void setIdPsi(String idPsi) {
        Psikolog.idPsi = idPsi;
    }

    public static String getNamaLengkap() {
        return namaLengkap;
    }

    public static void setNamaLengkap(String namaLengkap) {
        Psikolog.namaLengkap = namaLengkap;
    }

    public static String getUsrname() {
        return usrname;
    }

    public static void setUsrname(String usrname) {
        Psikolog.usrname = usrname;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        Psikolog.pass = pass;
    }

    public static String getMail() {
        return mail;
    }

    public static void setMail(String mail) {
        Psikolog.mail = mail;
    }

    public static String getNoHandphone() {
        return noHandphone;
    }

    public static void setNoHandphone(String noHandphone) {
        Psikolog.noHandphone = noHandphone;
    }

    public static String getTglLahir() {
        return tglLahir;
    }

    public static void setTglLahir(String tglLahir) {
        Psikolog.tglLahir = tglLahir;
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getNama() {
        return nama.get();
    }

    public StringProperty namaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getNohp() {
        return nohp.get();
    }

    public StringProperty nohpProperty() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp.set(nohp);
    }

    public String getTanggal() {
        return tanggal.get();
    }

    public StringProperty tanggalProperty() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal.set(tanggal);
    }

    public static String getNm() {
        return nm;
    }

    public static void setNm(String nm) {
        Psikolog.nm = nm;
    }

    public static String getHandphone() {
        return handphone;
    }

    public static void setHandphone(String handphone) {
        Psikolog.handphone = handphone;
    }
}
