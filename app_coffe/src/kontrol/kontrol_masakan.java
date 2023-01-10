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
public class kontrol_masakan extends koneksi {
    public kontrol_masakan() {
        setkonek();
    }
    
    public void simpandata(String idmasakan, String namamasakan, int harga, String statusmasakan) {
       String sql = "INSERT INTO masakan VALUES ('"+idmasakan+"','"+namamasakan+"','"+harga+"','"+statusmasakan+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_masakan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void tampildata (DefaultTableModel dtm){
        String sql = "SELECT * FROM masakan";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[4];
            while(rs.next()) {
                data[0] = rs.getString("id_masakan");
                data[1] = rs.getString("nama_masakan");
                data[2] = rs.getInt("harga");
                data[3] = rs.getString("status_masakan");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_masakan.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void updatedata(String idmasakan, String namamasakan, int harga, String statusmakanan) {
         String sql = "UPDATE masakan SET nama_masakan = '"+namamasakan+"', harga = '"+harga+"', status_masakan = '"+statusmakanan+"' WHERE id_masakan = '"+idmasakan+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_masakan.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public void hapusdata(String idmasakan) {
        String sql = "DELETE FROM masakan WHERE id_masakan = '"+idmasakan+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_masakan.class.getName()).log(Level.SEVERE, null, ex);
        } 
      }
      
      public ResultSet cari(String cari) throws Exception {
          String sql = "SELECT * FROM masakan WHERE id_masakan = '"+cari+"'";
          return rs = st.executeQuery(sql);
      }

      public ResultSet caridata(DefaultTableModel dtm, String cari) {
        try {
            String sql = "SELECT * FROM masakan WHERE id_masakan LIKE '%"+cari+"%' OR nama_masakan LIKE '%"+cari+"%' OR harga LIKE '%"+cari+"%'";
            rs = st.executeQuery(sql);
            Object [] data = new Object[4];
                while(rs.next()) {
                data[0] = rs.getString("id_masakan");
                data[1] = rs.getString("nama_masakan");
                data[2] = rs.getInt("harga");
                data[3] = rs.getString("status_masakan");
                dtm.addRow(data);
                
             }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_masakan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
         
        
        
      }
     
        
        
      }

