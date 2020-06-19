package powerpuffgirls.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Laporan {
    public Laporan(String id, String nama, String tanggal, String alamat, String noHP, String kronologi) {
        this.id = new SimpleStringProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.tanggal = new SimpleStringProperty (tanggal);
        this.alamat = new SimpleStringProperty(alamat);
        this.noHP = new SimpleStringProperty(noHP);
        this.kronologi = new SimpleStringProperty(kronologi);
    }

    private StringProperty id;
    private StringProperty nama;
    private StringProperty tanggal;
    private StringProperty alamat;
    private StringProperty noHP;
    private StringProperty kronologi;

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

    public String getAlamat() {
        return alamat.get();
    }

    public StringProperty alamatProperty() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
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

    public String getKronologi() {
        return kronologi.get();
    }

    public StringProperty kronologiProperty() {
        return kronologi;
    }

    public void setKronologi(String kronologi) {
        this.kronologi.set(kronologi);
    }
}
