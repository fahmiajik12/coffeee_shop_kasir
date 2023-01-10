/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kontrol;
import java.sql.*;
/**
 *
 * @author RPL22
 */
public class kontrol_login extends koneksi{
    public kontrol_login() {
        setkonek();
    }
    
   public ResultSet login (String username, String password) throws SQLException{
       rs = st.executeQuery("SELECT * FROM user WHERE username ='"+username+"' AND password = '"+password+"'");
       return rs;
   } 
   
}
