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
public class Borc {
    private int borc_id;
    private int sicil_id;
    private int toplam_borc;
    private int taksit;
    private Date tarih;
    private String odendi;
    private Sicil sicil;

    public Borc() {
    }

    public Borc(int sicil_id, int toplam_borc, int taksit, Date tarih, String odendi, Sicil sicil) {
        
        this.sicil_id = sicil_id;
        this.toplam_borc = toplam_borc;
        this.taksit = taksit;
        this.tarih = tarih;
        this.odendi = odendi;
        this.sicil = sicil;
    }

    public int getBorc_id() {
        return borc_id;
    }

    public void setBorc_id(int borc_id) {
        this.borc_id = borc_id;
    }

    public int getSicil_id() {
        return sicil_id;
    }

    public void setSicil_id(int sicil_id) {
        this.sicil_id = sicil_id;
    }

    public int getToplam_borc() {
        return toplam_borc;
    }

    public void setToplam_borc(int toplam_borc) {
        this.toplam_borc = toplam_borc;
    }

    public int getTaksit() {
        return taksit;
    }

    public void setTaksit(int taksit) {
        this.taksit = taksit;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public String getOdendi() {
        return odendi;
    }

    public void setOdendi(String odendi) {
        this.odendi = odendi;
    }

    public Sicil getSicil() {
        return sicil;
    }

    public void setSicil(Sicil sicil) {
        this.sicil = sicil;
    }
    
}
