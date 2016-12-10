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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.BorcDetay;

/**
 *
 * @author ahmedsalihh
 */
public class BorcDetayDao {

    public void borcDetayEkle(BorcDetay borcDetay) {

        Connection con = null;
        PreparedStatement pst = null;

        String url = "jdbc:postgresql://localhost/borctakip";
        String user = "postgres";
        String password = "123";

        try {

            con = DriverManager.getConnection(url, user, password);

            String stm = "INSERT INTO borc_detay("
                    + "odeme_gunu,"
                    + "aylik_borc,"
                    + "odendi_detay,"
                    + "borc_id) "
                    + "VALUES(\'"
                    + borcDetay.getOdeme_gunu() + "\',"
                    + borcDetay.getAylik_borc() + ",\'"
                    + borcDetay.getOdendi_detay() + "\',"
                    + borcDetay.getBorc_id() + ")";

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

    public JTable borcluListele(JTable table) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSetMetaData metaData;
        try {
            // database location, database user, database password
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/borctakip", "postgres", "123");
            st = conn.createStatement();
            String qs = "select "
                    + "s.tcno           as \"TCNO\", "
                    + "s.ad             as \"Adi\", "
                    + "s.soyad          as \"Soyadi\", "
                    + "s.telefon        as \"Telefon\" "
                    + "b.toplam_borc    as \"Toplam Borc\", "
                    + "b.taksit         as \"Taksit\", "
                    + "b.odendi         as \"Durum\" from sicil s,borc b;";
            rs = st.executeQuery(qs);

            metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnLabel(i));
            }

            Object[] row = new Object[columnCount];

            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                tableModel.addRow(row);
            }

            table.setModel(tableModel);

        } catch (SQLException sqle) {
            System.out.println("Could not connect");
            sqle.printStackTrace();
            System.exit(1);
        }

        return table;
    }

}
