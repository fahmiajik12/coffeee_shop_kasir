/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kontrol;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RPL22
 */
public class kontrol_transaksi extends koneksi{
    public kontrol_transaksi(){
        setkonek();
    }
    public void tampil(DefaultTableModel dtm,String cari){
    String sql = "SELECT * FROM masakan,detail_order WHERE masakan.id_masakan=detail_order.id_masakan AND detail_order.id_order LIKE '%"+cari+"%'";
        try {
            rs=st.executeQuery(sql);
            Object[] data = new Object[4];
            while(rs.next()){
            data[0]=rs.getString("id_detail_order");
            data[1]=rs.getString("id_order");
            data[2]=rs.getString("nama_masakan");
            data[3]=rs.getString("keterangan");
            dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet total (String total) {
        String sql = "SELECT SUM(masakan.harga*detail_order.keterangan) AS total FROM masakan,detail_order WHERE masakan.id_masakan ="
                + " detail_order.id_masakan AND detail_order.id_order = '"+total+"' GROUP BY detail_order.id_order";
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void simpandata(String iduser, String idorder, String tanggal, int total) {
        String sql = "INSERT INTO transaksi VALUES (null,'"+iduser+"','"+idorder+"','"+tanggal+"','"+total+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
