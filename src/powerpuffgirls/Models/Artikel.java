package powerpuffgirls.Models;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Artikel extends ORM {
    private static final String TABLE_NAME="Artikel";
    private String NamaPenerbit;
    private String KotaPenerbit;
    private String TanggalTerbit;
    private String JudulArtikel;
    private String IsiArtikel;

    public Artikel(String namaPenerbit, String kotaPenerbit, String tanggalTerbit, String judulArtikel, String isiArtikel) {
        NamaPenerbit=namaPenerbit;
        KotaPenerbit=kotaPenerbit;
        TanggalTerbit=tanggalTerbit;
        JudulArtikel=judulArtikel;
        IsiArtikel=isiArtikel;
    }

    public static ArrayList<Artikel> getArtikel(){
        ResultSet result = selectAll(TABLE_NAME);
        ArrayList<Artikel> artikel =new ArrayList<>();
        try {
            while (result.next()){
                String NamaPenerbit= result.getString("NamaPenerrbit");
                String KotaPenerbit= result.getString("KotaPenerbit");
                String TanggalTerbit= result.getString("TanggalTerbit");
                String JudulArtikel= result.getString("JudulArtikel");
                String IsiArtikel= result.getString("IsiArtikel");
                Artikel artikelModel = new Artikel(NamaPenerbit, KotaPenerbit,TanggalTerbit,JudulArtikel,IsiArtikel);
                artikel.add(artikelModel);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return artikel;
    }

    public String getNamaPenerbit() {
        return NamaPenerbit;
    }

    public void setNamaPenerbit(String namaPenerbit) {
        NamaPenerbit = namaPenerbit;
    }

    public String getKotaPenerbit() {
        return KotaPenerbit;
    }

    public void setKotaPenerbit(String kotaPenerbit) {
        KotaPenerbit = kotaPenerbit;
    }

    public String getTanggalTerbit() {
        return TanggalTerbit;
    }

    public void setTanggalTerbit(String tanggalTerbit) {
        TanggalTerbit = tanggalTerbit;
    }

    public String getJudulArtikel() {
        return JudulArtikel;
    }

    public void setJudulArtikel(String judulArtikel) {
        JudulArtikel = judulArtikel;
    }

    public String getIsiArtikel() {
        return IsiArtikel;
    }

    public void setIsiArtikel(String isiArtikel) {
        IsiArtikel = isiArtikel;
    }
}
