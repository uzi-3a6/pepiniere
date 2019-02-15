/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DB.MyDBcon;
import Entites.Adresse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author zorgati
 */
public class AdresseService {
    Connection cnx;

    public AdresseService() throws SQLException {
         cnx = MyDBcon.getInstance().getCnx();
    }
    
    public int ajouterAdresse(Adresse a) {
         try {
             
             String req = "INSERT INTO `adresse`(`gouvernorat`, `codePostale`, `citee`, `rue`, `numero`, `description`) VALUES (?,?,?,?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
             pstm.setString(1, a.getGouvernorat());
             pstm.setInt(2, a.getCodePostale());
             pstm.setString(3, a.getCitee());
             pstm.setString(4, a.getRue());
             pstm.setInt(5, a.getNumero());
             pstm.setString(6, a.getDescription());
             
             pstm.executeUpdate();
             ResultSet result = pstm.getGeneratedKeys();
             if(result.next())return result.getInt(1);
         } catch (SQLException ex) {
             Logger.getLogger(AdresseService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return -1;
    }
    
    public void modifierAdresse(Adresse a) {
         try {
             
             String req = "UPDATE `adresse` SET `gouvernorat`=?,`codePostale`=?,`citee`=?,`rue`=?,`numero`=?,`description`=? WHERE `idAdresse`=? ";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1, a.getGouvernorat());
             pstm.setInt(2, a.getCodePostale());
             pstm.setString(3, a.getCitee());
             pstm.setString(4, a.getRue());
             pstm.setInt(5, a.getNumero());
             pstm.setString(6, a.getDescription());
             pstm.setInt(7, a.getIdAdresse());
             
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(AdresseService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void supprimerAdresse(int idAdress) {
         try {
             
             String req = "DELETE FROM `adresse` WHERE ?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, idAdress);
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(AdresseService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    public Adresse getAdresse(int idAdresse) throws SQLException {
         
             
             String req = "SELECT Adresse.* FROM `adresse` WHERE `idAdresse`= ? ";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, idAdresse);
             ResultSet result = pstm.executeQuery();
             
             result.next();
             //return (Adresse)result.getObject(1);
            return new Adresse(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5), result.getInt(6), result.getString(7));
         
        
    }
    
    public ArrayList<Adresse> getAdresses() throws SQLException {
         ArrayList<Adresse> adresses = new ArrayList<>();
         
             String req = "SELECT * FROM `adresse`";
             PreparedStatement pstm = cnx.prepareStatement(req);
             ResultSet result = pstm.executeQuery();
             while(result.next()){              
                 adresses.add(new Adresse(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5), result.getInt(6), result.getString(7)));
             }
             return adresses;
         
        
    }
    
    
    
    
}
