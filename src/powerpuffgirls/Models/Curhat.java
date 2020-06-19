package powerpuffgirls.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Curhat {

    public Curhat(String id, String nama, String tanggal, String usia, String noHP, String isi) {
        this.id = new SimpleStringProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.tanggal = new SimpleStringProperty(tanggal);
        this.usia = new SimpleStringProperty(usia);
        this.noHP = new SimpleStringProperty(noHP);
        this.isi = new SimpleStringProperty(isi);
    }

    private StringProperty id;
    private StringProperty nama;
    private StringProperty tanggal;
    private StringProperty usia;
    private StringProperty noHP;
    private StringProperty isi;

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

    public String getTanggal() {
        return tanggal.get();
    }

    public StringProperty tanggalProperty() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal.set(tanggal);
    }

    public String getUsia() {
        return usia.get();
    }

    public StringProperty usiaProperty() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia.set(usia);
    }

    public String getNoHP() {
        return noHP.get();
    }

    public StringProperty noHPProperty() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP.set(noHP);
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
}
