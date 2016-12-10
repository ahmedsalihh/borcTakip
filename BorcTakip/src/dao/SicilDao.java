/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Sicil;

/**
 *
 * @author ahmedsalihh
 */
public class SicilDao {
    
    public Sicil sicilGetirTC(String tc){
    
        Statement st = null;
        ResultSet rs = null;
        Sicil sicil=new Sicil();
        try {
                Class.forName("org.postgresql.Driver");
                System.out.println("connect Sicil");
        } catch (ClassNotFoundException cnfe) {
                System.out.println("Could not find the JDBC driver!");
                System.exit(1);
        }
        Connection conn = null;
        try {
                // database location, database user, database password
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/borctakip", "postgres", "123");
                st = conn.createStatement();
                String qs = "select * from sicil where tcno=\'"+tc+"\'";
                rs=st.executeQuery(qs);
                
                if(rs.next()){
                    sicil.setSicil_id(rs.getInt("sicil_id"));
                    sicil.setTCNO(rs.getString("TCNO"));
                    sicil.setAd(rs.getString("ad"));
                    sicil.setSoyad(rs.getString("soyad"));
                    sicil.setTelefon(rs.getString("telefon"));
                    sicil.setAdres(rs.getString("adress"));
                    sicil.setAciklama(rs.getString("aciklama"));
                }

        } catch (SQLException sqle) {
                System.out.println("Could not connect");
                sqle.printStackTrace();
                System.exit(1);
        }
        
        return sicil;
    }
    
    public Sicil sicilGetir(int id){
    
        Statement st = null;
        ResultSet rs = null;
        Sicil sicil=new Sicil();
        try {
                Class.forName("org.postgresql.Driver");
                System.out.println("connect Sicil");
        } catch (ClassNotFoundException cnfe) {
                System.out.println("Could not find the JDBC driver!");
                System.exit(1);
        }
        Connection conn = null;
        try {
                // database location, database user, database password
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/borctakip", "postgres", "123");
                st = conn.createStatement();
                String qs = "select * from sicil where sicil_id="+id;
                rs=st.executeQuery(qs);
                
                if(rs.next()){
                    sicil.setSicil_id(rs.getInt("sicil_id"));
                    sicil.setTCNO(rs.getString("TCNO"));
                    sicil.setAd(rs.getString("ad"));
                    sicil.setSoyad(rs.getString("soyad"));
                    sicil.setTelefon(rs.getString("telefon"));
                    sicil.setAdres(rs.getString("adress"));
                    sicil.setAciklama(rs.getString("aciklama"));
                }

        } catch (SQLException sqle) {
                System.out.println("Could not connect");
                sqle.printStackTrace();
                System.exit(1);
        }finally {

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
        }
        
        return sicil;
    }
    
    public void sicilEkle(Sicil sicil){
        Connection con = null;
        PreparedStatement pst = null;

        String url = "jdbc:postgresql://localhost/borctakip";
        String user = "postgres";
        String password = "123";

        try {


            con = DriverManager.getConnection(url, user, password);

            String stm = "INSERT INTO sicil("
                            + "TCNO,"
                            + "ad,"
                            + "soyad,"
                            + "telefon,"
                            + "adress,"
                            + "aciklama) "
                            + "VALUES(\'"
                            + sicil.getTCNO()+"\',\'"
                            + sicil.getAd()+"\',\'"
                            + sicil.getSoyad()+"\',\'"
                            + sicil.getTelefon()+"\',\'"
                            + sicil.getAdres()+"\',\'"
                            + sicil.getAciklama()+"\')";

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
    
    public JTable sicilListele(JTable table){
        Connection conn = null;
        Statement st=null;
        ResultSet rs=null;
        
        DefaultTableModel tableModel=new DefaultTableModel();
        ResultSetMetaData metaData;
        try {
                // database location, database user, database password
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/borctakip", "postgres", "123");
                st = conn.createStatement();
                String qs = "select "
                        + "tcno     as \"TCNO\", "
                        + "ad       as \"Adi\", "
                        + "soyad    as \"Soyadi\", "
                        + "telefon  as \"Telefon\", "
                        + "adress   as \"Adres\", "
                        + "aciklama as \"Aciklama\" from sicil";
                rs=st.executeQuery(qs);
                
                metaData=rs.getMetaData();
                int columnCount=metaData.getColumnCount();
                
                for(int i=1;i<=columnCount;i++){
                    tableModel.addColumn(metaData.getColumnLabel(i));
                }
                
                Object[] row=new Object[columnCount];
                
                while(rs.next()){
                    for (int i=0;i<columnCount;i++){
                        row[i]=rs.getObject(i+1);
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
