package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class YetkiDao {
	
    public void createTableYetki() {

        Statement st = null;
        // ResultSet rs = null;
        try {
                Class.forName("org.postgresql.Driver");
                System.out.println("connect yetki");
        } catch (ClassNotFoundException cnfe) {
                System.out.println("Could not find the JDBC driver!");
                System.exit(1);
        }
        Connection conn = null;
        try {
                // database location, database user, database password
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/borctakip", "postgres", "123");
                st = conn.createStatement();
                String qs = "CREATE TABLE IF NOT EXISTS yetki (" 
                                + "yetki_id 		SERIAL NOT NULL PRIMARY KEY,"
                                + "yetki_ad 		varchar(25) NOT NULL)";
                st.execute(qs);

        } catch (SQLException sqle) {
                System.out.println("Could not connect");
                sqle.printStackTrace();
                System.exit(1);
        }
    }

}
