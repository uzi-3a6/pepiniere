/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DB.MyDBcon;
import Entites.Adresse;
import Entites.Jardinier;
import Entites.User;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author zorgati
 */
public class UserService {
    
    Connection cnx;
    public UserService() throws SQLException{
        cnx = MyDBcon.getInstance().getCnx();
    }
    public void ajouterUser(User u){
        try {
             
             String req = "INSERT INTO `fos_user`(`username`, `email`, `enabled`, `password`, `role`, `last_login`, `nom`, `prenom`) VALUES (?,?,?,?,?,?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1, u.getUsername());
             pstm.setString(2, u.getEmail());
             pstm.setBoolean(3, u.isEnabled());
             pstm.setString(4, u.getPassword());
             pstm.setInt(5, u.getRole());
             pstm.setDate(6, u.getLastLogin());
             pstm.setString(7, u.getNom());
             pstm.setString(7, u.getPrenom());

             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    public User authentication(String usern, String passw) {
         //User u=new User();
          
        try {
            String req = "SELECT * FROM `fos_user` WHERE username=? and password=? ";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setString(1, usern);
            pstm.setString(2, passw);
            ResultSet result=pstm.executeQuery();
            if (!result.next())
            return null;
            if(!result.getBoolean("enabled"))
                return null;
            
            int id = result.getInt("id");
            String username = result.getString("username");
            String email = result.getString("email");
            boolean enabled = result.getBoolean("enabled");
            String password = result.getString("password");
            Date lastLogin = result.getDate("last_login");
            int role = result.getInt("role");
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            AdresseService ads = new AdresseService();
            Adresse adresse = ads.getAdresse(result.getInt("adresse"));
            String telephone = result.getString("telephone");
            if(result.getInt("role")==3){
                
            }
            
            return new User(id, username, email, enabled, password, lastLogin, role, nom, prenom, adresse, telephone);

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
    
    public boolean verifMailUsername(String username, String mail) throws SQLException{
        String req = "Select * from fos_user where email=? or username=?";
        PreparedStatement pstm = cnx.prepareStatement(req);
        pstm.setString(1,mail);
        pstm.setString(2,username);
        ResultSet result = pstm.executeQuery();
        return result.next();
    }
    
    public boolean inscription(User u) throws SQLException{
        
        if(verifMailUsername(u.getUsername(), u.getEmail()))
            return false;
        
        try {
            u.setConfirmationToken(generateToken());
            
             String req = "INSERT INTO `fos_user`(`username`, `email`, `enabled`, `password`, `role` , confirmation_token ) VALUES (?,?,?,?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
             pstm.setString(1, u.getUsername());
             pstm.setString(2, u.getEmail());
             pstm.setBoolean(3, false);
             pstm.setString(4, u.getPassword());
             pstm.setInt(5, u.getRole());
             pstm.setString(6, u.getConfirmationToken());
             

            pstm.executeUpdate();
            ResultSet result = pstm.getGeneratedKeys();
            if(result.next()) u.setId(result.getInt(1));
         } catch (SQLException ex) {
             Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
         }
          
        return true;
        
    }
    
    public String generateToken() {
        int len = 7;
        char[] ch = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    char[] c = new char[len];
    SecureRandom random = new SecureRandom();
    for (int i = 0; i < len; i++) {
      c[i] = ch[random.nextInt(ch.length)];
    }
    //System.out.println();
    return new String(c);
    
    
    }
    
    public boolean verifierToken(User u) throws SQLException{
        String req = "Select confirmation_token from fos_user where confirmation_token=? and id=?";
        PreparedStatement pstm = cnx.prepareStatement(req);
        pstm.setString(1,u.getConfirmationToken());
        pstm.setInt(2,u.getId());
        ResultSet result = pstm.executeQuery();
        if(!result.next())
            return false;
        else{
            String req2 = "Update fos_user Set enabled= 1 , confirmation_token= null where id=?";
            PreparedStatement pstm2 = cnx.prepareStatement(req2);
            pstm2.setInt(1,u.getId());
            ResultSet result2 = pstm2.executeQuery();
            u=authentication(u.getUsername(),u.getPassword());
            return true;
        }
    }
    
}
