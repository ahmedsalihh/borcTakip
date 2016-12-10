/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author ahmedsalihh
 */
public class BorcDetay {
    
    private int detay_id;
    private Date odeme_gunu;
    private int aylik_borc;
    private String odendi_detay;
    private int borc_id;
    private Borc borc;

    public BorcDetay() {
    }

    public BorcDetay(Date odeme_gunu, int aylik_borc, String odendi_detay, int borc_id, Borc borc) {
        this.odeme_gunu = odeme_gunu;
        this.aylik_borc = aylik_borc;
        this.odendi_detay = odendi_detay;
        this.borc_id = borc_id;
        this.borc = borc;
    }

    public int getDetay_id() {
        return detay_id;
    }

    public void setDetay_id(int detay_id) {
        this.detay_id = detay_id;
    }

    public Date getOdeme_gunu() {
        return odeme_gunu;
    }

    public void setOdeme_gunu(Date odeme_gunu) {
        this.odeme_gunu = odeme_gunu;
    }

    public int getAylik_borc() {
        return aylik_borc;
    }

    public void setAylik_borc(int aylik_borc) {
        this.aylik_borc = aylik_borc;
    }

    public String getOdendi_detay() {
        return odendi_detay;
    }

    public void setOdendi_detay(String odendi_detay) {
        this.odendi_detay = odendi_detay;
    }

    public int getBorc_id() {
        return borc_id;
    }

    public void setBorc_id(int borc_id) {
        this.borc_id = borc_id;
    }

    public Borc getBorc() {
        return borc;
    }

    public void setBorc(Borc borc) {
        this.borc = borc;
    }    
    
}
