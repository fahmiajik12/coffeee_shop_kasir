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
public class kontrol_user extends koneksi {
    public kontrol_user(){
        setkonek();
    }
    
    
    public void simpandata (String iduser, String username, String password, String nama, String idlevel){
       String sql = "INSERT INTO user VALUES ('"+iduser+"','"+username+"','"+password+"','"+nama+"','"+idlevel+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampildata (DefaultTableModel dtm){
        String sql = "SELECT * FROM user";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[5];
            while (rs.next()){
                data[0] = rs.getString("id_user");
                data[1] = rs.getString("username");
                data[2] = rs.getString("password");
                data[3] = rs.getString("nama_user");
                data[4] = rs.getString("id_level");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public void updatedata (String iduser, String username, String password, String nama, String idlevel){
        String sql = "UPDATE user SET username = '"+username+"', password = '"+password+"', nama_user = '"+nama+"', id_level = '"+idlevel+"' WHERE id_user = '"+iduser+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hapusdata(String iduser) {
        String sql = "DELETE FROM user WHERE id_user = '"+iduser+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet setcombobox() throws SQLException {
        String sql = "SELECT id_level FROM level";
        rs = st.executeQuery(sql);
        return rs;
      }
    
    public ResultSet carilevel (String cari) throws SQLException {
       String sql = "SELECT * FROM level WHERE id_level = '"+cari+"'";
       return rs = st.executeQuery(sql);
    }
    
    public ResultSet setlogin(String username, String password) throws SQLException {
        String sql = "SELECT * FROM user,level WHERE username = '"+username+"' AND password = '"+password+"'";
        return rs = st.executeQuery(sql);
        
    }
}
       