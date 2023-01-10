/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kontrol;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author RPL22
 */
public class kontrol_level extends koneksi {
    public kontrol_level() {
        setkonek();
    }
    
    public void simpandata(String idlevel, String namalevel) {
       String sql = "INSERT INTO level VALUES ('"+idlevel+"','"+namalevel+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_level.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void tampildata (DefaultTableModel dtm){
        String sql = "SELECT * FROM level";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[2];
            while(rs.next()) {
                data[0] = rs.getString("id_level");
                data[1] = rs.getString("nama_level");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_level.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void updatedata(String idlevel, String namalevel) {
         String sql = "UPDATE level SET nama_level = '"+namalevel+"' WHERE id_level = '"+idlevel+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_level.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public void hapusdata(String idlevel) {
        String sql = "DELETE FROM level WHERE id_level = '"+idlevel+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_level.class.getName()).log(Level.SEVERE, null, ex);
        } 
      }
}
