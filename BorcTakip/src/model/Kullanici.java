package model;

import java.util.ArrayList;
import java.util.List;

public class Kullanici {

    private int killanici_id;
    private String kullanici_adi;
    private String kullanici_ad;
    private String kullanici_soyad;
    private String tel_no;
    private String sifre;
    private int yetki_id;
    private List<Yetki> yetkiList;

    public Kullanici(String kullanici_adi, String tel_no, String sifre, int yetki_id, String kullanici_ad, String kullanici_soyad) {
        super();
        this.kullanici_adi = kullanici_adi;
        this.tel_no = tel_no;
        this.sifre = sifre;
        this.yetki_id = yetki_id;
        this.kullanici_ad = kullanici_ad;
        this.kullanici_soyad = kullanici_soyad;
        this.yetkiList = new ArrayList<>();
    }

    public String getKullanici_ad() {
        return kullanici_ad;
    }

    public void setKullanici_ad(String kullanici_ad) {
        this.kullanici_ad = kullanici_ad;
    }

    public String getKullanici_soyad() {
        return kullanici_soyad;
    }

    public void setKullanici_soyad(String kullanici_soyad) {
        this.kullanici_soyad = kullanici_soyad;
    }

    public Kullanici() {
        super();
    }

    public int getKillanici_id() {
        return killanici_id;
    }

    public void setKillanici_id(int killanici_id) {
        this.killanici_id = killanici_id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public int getYetki_id() {
        return yetki_id;
    }

    public void setYetki_id(int yetki_id) {
        this.yetki_id = yetki_id;
    }

    public List<Yetki> getYetkiList() {
        return yetkiList;
    }

    public void setYetkiList(List<Yetki> yetkiList) {
        this.yetkiList = yetkiList;
    }

}
