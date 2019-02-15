/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DB.MyDBcon;
import Entites.Specialite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zorgati
 */
public class SpecialiteService {
    Connection cnx;
    public SpecialiteService() throws SQLException{
        cnx = MyDBcon.getInstance().getCnx();
    }
    public int ajouterSpecialite(Specialite sp){
        try {
             
             String req = "INSERT INTO `specialite`(`nom`) VALUES (?)";
             PreparedStatement pstm = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
             pstm.setString(1, sp.getNom());
             pstm.executeUpdate();
             ResultSet result = pstm.getGeneratedKeys();
             if(result.next())return result.getInt(1);
         } catch (SQLException ex) {
             Logger.getLogger(SpecialiteService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return -1;
    }
    
    public void modifierSpecialite(Specialite sp){
        try {
             
             String req = "UPDATE `specialite` SET `nom`=? WHERE `idSpecialite`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1, sp.getNom());
             pstm.setInt(2, sp.getIdSpecialite());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(SpecialiteService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    public void supprimerSpecialite(Specialite sp){
        try {
             
             String req = "DELETE FROM `specialite` WHERE `idSpecialite`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, sp.getIdSpecialite());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(SpecialiteService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void getSpecialite(Specialite sp) throws SQLException{
        
             String req = "SELECT `idSpecialite`, `nom` FROM `specialite` WHERE `idSpecialite`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, sp.getIdSpecialite());
             ResultSet result= pstm.executeQuery();
             result.next();
             sp.setNom(result.getString(2));   
    }
    
    public ArrayList<Specialite> getSpecialites() throws SQLException{
        ArrayList<Specialite> sps = new ArrayList<>();
        String req = "SELECT `idSpecialite`, `nom` FROM `specialite`";
        PreparedStatement pstm = cnx.prepareStatement(req);
        ResultSet result= pstm.executeQuery();
        while(result.next()){
            sps.add(new Specialite(result.getInt(1), result.getString(2)));
        }            
        return sps;
    }
}
