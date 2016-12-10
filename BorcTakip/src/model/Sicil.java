/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ahmedsalihh
 */
public class Sicil {
    private int sicil_id;
    private String TCNO;
    private String ad;
    private String soyad;
    private String telefon;
    private String adres;
    private String aciklama;

    public Sicil() {
    }

    public Sicil(String TCNO, String ad, String soyad, String telefon, String adres, String aciklama) {
        this.TCNO = TCNO;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.adres = adres;
        this.aciklama = aciklama;
    }   

    /**
     * @return the sicil_id
     */
    public int getSicil_id() {
        return sicil_id;
    }

    /**
     * @param sicil_id the sicil_id to set
     */
    public void setSicil_id(int sicil_id) {
        this.sicil_id = sicil_id;
    }

    /**
     * @return the TCNO
     */
    public String getTCNO() {
        return TCNO;
    }

    /**
     * @param TCNO the TCNO to set
     */
    public void setTCNO(String TCNO) {
        this.TCNO = TCNO;
    }

    /**
     * @return the ad
     */
    public String getAd() {
        return ad;
    }

    /**
     * @param ad the ad to set
     */
    public void setAd(String ad) {
        this.ad = ad;
    }

    /**
     * @return the soyad
     */
    public String getSoyad() {
        return soyad;
    }

    /**
     * @param soyad the soyad to set
     */
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon the telefon to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * @return the adres
     */
    public String getAdres() {
        return adres;
    }

    /**
     * @param adres the adres to set
     */
    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
    
    
    
}
