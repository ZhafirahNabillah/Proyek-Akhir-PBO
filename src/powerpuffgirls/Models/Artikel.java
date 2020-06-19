package powerpuffgirls.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Artikel  {
    public Artikel(String id, String nama, String kota, String tanggal, String judul, String isiArtikel, String idAdmin) {
        this.id = new SimpleStringProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.kota = new SimpleStringProperty(kota);
        this.tanggal = new SimpleStringProperty(tanggal);
        this.judul = new SimpleStringProperty(judul);
        this.isiArtikel = new SimpleStringProperty(isiArtikel);
    }

    private StringProperty id;
    private StringProperty nama;
    private StringProperty kota;
    private StringProperty tanggal;
    private StringProperty judul;
    private StringProperty isiArtikel;

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

    public String getKota() {
        return kota.get();
    }

    public StringProperty kotaProperty() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota.set(kota);
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

    public String getJudul() {
        return judul.get();
    }

    public StringProperty judulProperty() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul.set(judul);
    }

    public String getIsiArtikel() {
        return isiArtikel.get();
    }

    public StringProperty isiArtikelProperty() {
        return isiArtikel;
    }

    public void setIsiArtikel(String isiArtikel) {
        this.isiArtikel.set(isiArtikel);
    }
}
