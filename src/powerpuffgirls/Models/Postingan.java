package powerpuffgirls.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Postingan {
    public Postingan(String id, String nama, String username, String isi, String tanggal, String status, String idUser) {
        this.id = new SimpleStringProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.username = new SimpleStringProperty(username);
        this.isi = new SimpleStringProperty(isi);
        this.tanggal = new SimpleStringProperty(tanggal);
        this.status = new SimpleStringProperty(status);
        this.idUser = new SimpleStringProperty(idUser);

    }

    private StringProperty id;
    private StringProperty nama;
    private StringProperty username;
    private StringProperty isi;
    private StringProperty tanggal;
    private StringProperty status;
    private StringProperty idUser;

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

    public String getIsi() {
        return isi.get();
    }

    public StringProperty isiProperty() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi.set(isi);
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

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getIdUser() {
        return idUser.get();
    }

    public StringProperty idUserProperty() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser.set(idUser);
    }
}
