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
public class kontrol_order extends koneksi {
    public kontrol_order() {
        setkonek();
    }
    
    public void simpandataorder(String idorder, String nomeja, String tanggal, String iduser, String ket, String statusorder) {
       String sql = "INSERT INTO `order` VALUES ('"+idorder+"','"+nomeja+"','"+tanggal+"','"+iduser+"','"+ket+"','"+statusorder+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void simpandatadetailorder(String idorder, String idmasakan, String ket, String status) {
       String sql = "INSERT INTO detail_order VALUES (null,'"+idorder+"','"+idmasakan+"','"+ket+"','"+status+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void tampildata (DefaultTableModel dtm){
        String sql = "SELECT * FROM `order`";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[6];
            while(rs.next()) {
                data[0] = rs.getString("id_order");
                data[1] = rs.getString("no_meja");
                data[2] = rs.getDate("tanggal");
                data[3] = rs.getString("id_user");
                data[4] = rs.getString("keterangan");
                data[5] = rs.getString("status_order");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_order.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void updatedata (String idorder, String nomeja, String tanggal, String iduser, String ket, String statusorder) {
         String sql = "UPDATE `order` SET no_meja = '"+nomeja+"', tanggal = '"+tanggal+"', id_user = '"+iduser+"', keterangan = '"+ket+"', status_order = '"+statusorder+"' WHERE id_order = '"+idorder+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_order.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public void hapusdata(String idorder) {
        String sql = "DELETE FROM `order` WHERE id_order = '"+idorder+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_order.class.getName()).log(Level.SEVERE, null, ex);
        } 
      }
      
      public ResultSet setcombo() throws SQLException {
          String sql = "SELECT id_user FROM user WHERE id_level=1 OR id_level=2 OR id_level=5";
          return rs = st.executeQuery(sql);
      }
      
      
      public ResultSet setuser(String iduser) throws SQLException {
          String sql = "SELECT nama_user FROM user WHERE id_user = '"+iduser+"'";
          return rs = st.executeQuery(sql);
          
      }
      public ResultSet cekId(String id) throws SQLException{
          String sql = "SELECT * FROM `order` where id_order='"+id+"'";
          rs = st.executeQuery(sql);
          return rs;
      }
      
}
