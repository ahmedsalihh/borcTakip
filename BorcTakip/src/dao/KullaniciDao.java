package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Kullanici;

public class KullaniciDao {

    public void createTableKullanici() {

        Statement st = null;
        // ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("connect kullanici");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Could not find the JDBC driver!");
            System.exit(1);
        }
        Connection conn = null;
        try {
            // database location, database user, database password
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/borctakip", "postgres", "123");
            st = conn.createStatement();
            String qs = "CREATE TABLE IF NOT EXISTS kisi("
                    + "kullanici_id 		SERIAL NOT NULL PRIMARY KEY,"
                    + "kullanici_adi 		varchar(50) NOT NULL,"
                    + "telefon 	varchar(11),"
                    + "sifre 	varchar(225),"
                    + "yetki_id	integer NOT NULL REFERENCES yetki(yetki_id))";
            st.execute(qs);

        } catch (SQLException sqle) {
            System.out.println("Could not connect");
            sqle.printStackTrace();
            System.exit(1);
        }
    }

    public boolean kullaniciGirisi(String kullaniciAdi, String sifre) throws SQLException {

        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("connect kullanici");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Could not find the JDBC driver!");
            System.exit(1);
        }
        Connection conn = null;
        try {
            // database location, database user, database password
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/borctakip", "postgres", "123");
            st = conn.createStatement();
            String qs = "select * from kullanici where kullanici_adi=\'" + kullaniciAdi + "\' and sifre=\'" + sifre + "\'";
            rs = st.executeQuery(qs);

        } catch (SQLException sqle) {
            System.out.println("Could not connect");
            sqle.printStackTrace();
            System.exit(1);
        }

        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }

    public void kullaniciEkle(Kullanici kullanici) {

        Connection con = null;
        PreparedStatement pst = null;

        String url = "jdbc:postgresql://localhost/borctakip";
        String user = "postgres";
        String password = "123";

        try {

            con = DriverManager.getConnection(url, user, password);

            String stm = "INSERT INTO kullanici("
                    + "kullanici_adi,"
                    + "sifre,"
                    + "kullanici_ad,"
                    + "kullanici_soyad,"
                    + "telefon,"
                    + "yetki_id) "
                    + "VALUES(\'"
                    + kullanici.getKullanici_adi()+ "\',\'"
                    + kullanici.getSifre()+ "\',\'"
                    + kullanici.getKullanici_ad()+ "\',\'"
                    + kullanici.getKullanici_soyad()+ "\',\'"
                    + kullanici.getTel_no()+ "\',\'"
                    + kullanici.getYetki_id()+ "\')";

            pst = con.prepareStatement(stm);

            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

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

}
