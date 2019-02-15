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
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author zorgati
 */
public class JardinerService {
    Connection cnx;

    public JardinerService() throws SQLException {
         cnx = MyDBcon.getInstance().getCnx();
    }
    
    public void ajouterJardinier(Jardinier j) {
         try {
             AdresseService ads = new AdresseService();
             
             String req = "UPDATE `fos_user` SET `role`=3,`nom`=?,`prenom`=?,`adresse`=?,`telephone`=?,`descriptionJardinier`=?,`joursTravails`=? WHERE id= ?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1, j.getNom());
             pstm.setString(2, j.getPrenom());
             pstm.setInt(3, ads.ajouterAdresse(j.getAdresse()));
             pstm.setString(4, j.getTelephone());
             pstm.setString(5, j.getDescriptionJardinier());
             pstm.setString(6, j.getJoursTravails().stream().map(e -> e.toString().toUpperCase()).collect(Collectors.joining(",")));
             pstm.setInt(7, j.getId());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(JardinerService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void modifierJardinier(Jardinier j) {
         try {
             
             String req = "UPDATE `jardinier` SET `description`=?,`joursTavails`=?,`lieuDeTravail`=?,`idUser`=? WHERE `idJardinier`=? ";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1, j.getDescriptionJardinier());
             pstm.setString(2, j.getJoursTravails().stream().map(e -> e.toString().toUpperCase()).collect(Collectors.joining("|")));
             pstm.setInt(3, j.getAdresse().getIdAdresse());
             pstm.setInt(4, j.getId());
             
     
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(JardinerService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void supprimerJardinier(Jardinier j) {
         try {
             
             String req = "DELETE FROM `jardinier` WHERE `idJardinier`=? ";
             PreparedStatement pstm = cnx.prepareStatement(req);
             
             pstm.setInt(1, j.getId());
     
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(JardinerService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public Jardinier getJardinier(int idj) {
         try {
             
             String req = "SELECT u.*,tj.*,spj.* FROM fos_user u "
                     + "Inner JOIN travailjadinage tj on u.id= tj.idJardiner "
                     + "Inner JOIN specialitejadinier spj on spj.idJardinier = u.id"
                     + "Where id=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             
             pstm.setInt(1, idj);
     
             ResultSet result=pstm.executeQuery();
             if(!result.next()){
                 return null;
             }
             
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
             
            
             String descriptionJardinier = result.getString("descriptionJardinier");
             //System.out.println(new ArrayList<String>(Arrays.asList(result.getString("joursTravails").split(","))));
            ArrayList<Jardinier.Jours> joursTravails = Arrays.asList(result.getString("joursTravails").split(",")).stream().map(x->Jardinier.Jours.valueOf(x)).collect(Collectors.toCollection(()->new ArrayList<Jardinier.Jours>()));
            
            
            Jardinier j = new Jardinier(id, username, email, enabled, password, lastLogin, role, nom, prenom, adresse, telephone, descriptionJardinier, joursTravails);
            
             
             //TravailJardinageService tjs = new TravailJardinageService();
             //SpecialiteJardinierService sjs = new SpecialiteJardinierService();
             //j.setSpecialites(sjs.getSpecialiteJardinier(j));
             //j.setTravails(tjs.getTravailJardinier(j));
             
             return j;
         } catch (SQLException ex) {
             Logger.getLogger(JardinerService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;
    }
    
    public Jardinier getJardinier(User u) {
         try {
             
             String req = "SELECT descriptionjarginier,jourstravails FROM fos_user u Where id=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             
             pstm.setInt(1, u.getId());
     
             ResultSet result=pstm.executeQuery();
             if(!result.next()){
                 return null;
             }
             String descriptionJardinier = result.getString("descriptionJardinier");
             //System.out.println(new ArrayList<String>(Arrays.asList(result.getString("joursTravails").split(","))));
            ArrayList<Jardinier.Jours> joursTravails = Arrays.asList(result.getString("joursTravails").split(",")).stream().map(x->Jardinier.Jours.valueOf(x)).collect(Collectors.toCollection(()->new ArrayList<Jardinier.Jours>()));
            
            
            Jardinier j = new Jardinier(u, descriptionJardinier, joursTravails);
            
             
             //TravailJardinageService tjs = new TravailJardinageService();
             //SpecialiteJardinierService sjs = new SpecialiteJardinierService();
             //j.setSpecialites(sjs.getSpecialiteJardinier(j));
             //j.setTravails(tjs.getTravailJardinier(j));
             
             return j;
         } catch (SQLException ex) {
             Logger.getLogger(JardinerService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;
    }
    /*
    public ArrayList<Jardinier> getJardiniers() {
         try {
             
             String req = "SELECT * FROM `jardinier` WHERE 1";
             PreparedStatement pstm = cnx.prepareStatement(req);
             
             
     
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(JardinerService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
 */   
}
