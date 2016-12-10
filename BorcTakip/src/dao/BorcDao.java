/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Borc;
import model.BorcDetay;

/**
 *
 * @author ahmedsalihh
 */
public class BorcDao {

    public void borcEkle(Borc borc) {
        Connection con = null;
        PreparedStatement pst = null;
        BorcDetayDao borcDetayDao = new BorcDetayDao();
        BorcDetay borcDetay = new BorcDetay();

        String url = "jdbc:postgresql://localhost/borctakip";
        String user = "postgres";
        String password = "123";

        try {

            con = DriverManager.getConnection(url, user, password);

            String stm = "INSERT INTO borc("
                    + "toplam_borc,"
                    + "taksit,"
                    + "tarih,"
                    + "odendi,"
                    + "sicil_id) "
                    + "VALUES(\'"
                    + borc.getToplam_borc() + "\',\'"
                    + borc.getTaksit() + "\',\'"
                    + borc.getTarih() + "\',\'"
                    + borc.getOdendi() + "\',\'"
                    + borc.getSicil_id() + "\')";

            pst = con.prepareStatement(stm);

            int result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

            //} catch (ParseException ex) {
            //  Logger.getLogger(BorcDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public Borc borcGetir(int id) {

        Statement st = null;
        ResultSet rs = null;
        Borc borc = new Borc();
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("connect Borc");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Could not find the JDBC driver!");
            System.exit(1);
        }
        Connection conn = null;
        try {
            // database location, database user, database password
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/borctakip", "postgres", "123");
            st = conn.createStatement();
            String qs = "select * from borc where borc_id=" + id;
            rs = st.executeQuery(qs);

            if (rs.next()) {
                borc.setBorc_id(rs.getInt("borc_id"));
                borc.setToplam_borc(rs.getInt("toplam_borc"));
                borc.setTaksit(rs.getInt("taksit"));
                borc.setTarih(rs.getDate("tarih"));
                borc.setOdendi(rs.getString("odendi"));
                borc.setSicil_id(rs.getInt("sicil_id"));
            }

        } catch (SQLException sqle) {
            System.out.println("Could not connect");
            sqle.printStackTrace();
            System.exit(1);
        } finally {

            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return borc;
        }

    }
    
    public List<Borc> borcListele() {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        
        List<Borc> borcs = new ArrayList<>();
        SicilDao sicilDao=new SicilDao();
        
        try {
            // database location, database user, database password
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/borctakip", "postgres", "123");
            st = conn.createStatement();
            String qs = "select * from borc";
            rs = st.executeQuery(qs);

            while (rs.next()) {
                Borc borc = new Borc();
                borc.setBorc_id(rs.getInt("borc_id"));
                borc.setToplam_borc(rs.getInt("toplam_borc"));
                borc.setTaksit(rs.getInt("taksit"));
                borc.setTarih(rs.getDate("tarih"));
                borc.setOdendi(rs.getString("odendi"));
                borc.setSicil_id(rs.getInt("sicil_id"));
                borc.setSicil(sicilDao.sicilGetir(borc.getSicil_id()));

                borcs.add(borc);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return borcs;
    }
    
}
