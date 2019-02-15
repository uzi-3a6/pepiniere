/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DB.MyDBcon;
import Entites.Jardinier;
import Entites.Specialite;
import Entites.SpecialiteJardinier;
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
public class SpecialiteJardinierService {
    Connection cnx;
    public SpecialiteJardinierService() throws SQLException{
        cnx = MyDBcon.getInstance().getCnx();
    }
    public int ajouterSpecialiteJardinier(SpecialiteJardinier sp){
        
        try {
             
             String req = "INSERT INTO `specialitejadinier`(`tarif`, `idJardinier`, `idSpecialite`) VALUES (?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
             pstm.setDouble(1, sp.getTarif());
             pstm.setInt(2, sp.getJardinier().getId());
             pstm.setInt(3, sp.getSpecialite().getIdSpecialite());
             
             pstm.executeUpdate();
             ResultSet result = pstm.getGeneratedKeys();
             if(result.next())return result.getInt(1);
         } catch (SQLException ex) {
             Logger.getLogger(SpecialiteJardinierService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return -1;
    }
    
    public void modifierSpecialiteJardinier(SpecialiteJardinier sp){
        
        try {
             
             String req = "UPDATE `specialitejadinier` SET `tarif`=?,`idJardinier`=?,`idSpecialite`=? WHERE `idSpecialiteJadinier`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setDouble(1, sp.getTarif());
             pstm.setInt(2, sp.getJardinier().getId());
             pstm.setInt(3, sp.getSpecialite().getIdSpecialite());
             pstm.setInt(4, sp.getIdSpecialiteJardinier());
             
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(SpecialiteJardinierService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void supprimerSpecialiteJardinier(SpecialiteJardinier sp){
        
        try {
             
             String req = "DELETE FROM `specialitejadinier` WHERE `idSpecialiteJadinier`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, sp.getIdSpecialiteJardinier());
             
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(SpecialiteJardinierService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public SpecialiteJardinier getSpecialiteJardinierById(int idS) throws SQLException{
        

        String req = "SELECT `idSpecialiteJadinier`, `tarif` FROM `specialitejadinier` WHERE `idSpecialiteJadinier`=?";
        PreparedStatement pstm = cnx.prepareStatement(req);
        pstm.setInt(1, idS);
        ResultSet result= pstm.executeQuery();
        if(!result.next()){
            return null;
        }
        //Jardiner j = new Jardinier(result.);
        return new SpecialiteJardinier(idS, idS, req);

                
    }
    public ArrayList<SpecialiteJardinier> getAllSpecialiteJardinierById(int idS) throws SQLException{
        ArrayList<SpecialiteJardinier> ar= new ArrayList<>();
             
        String req = "SELECT `idSpecialiteJadinier`, `tarif` FROM `specialitejadinier` WHERE `idSpecialiteJadinier`=?";
        PreparedStatement pstm = cnx.prepareStatement(req);
        pstm.setInt(1, idS);
        ResultSet result= pstm.executeQuery();

        while(result.next()){
            ar.add(new SpecialiteJardinier(result.getInt("idSpecialite"), result.getDouble("tarif"), result.getString("description")));
        }
        return ar;  
    }
    
    public ArrayList<SpecialiteJardinier> getAllSpecialiteJardinierByJardinier(Jardinier j) throws SQLException{
        
        ArrayList<SpecialiteJardinier> ar= new ArrayList<>();
        String req = "SELECT `idSpecialiteJadinier`, `tarif` FROM `specialitejadinier` WHERE `idJadinier`=?";
        PreparedStatement pstm = cnx.prepareStatement(req);
        pstm.setInt(1, j.getId());
        ResultSet result= pstm.executeQuery();
        while(result.next()){
            ar.add(new SpecialiteJardinier(result.getInt("idSpecialite"), result.getDouble("tarif"), result.getString("description")));
        }
        return ar;      
    }
    public ArrayList<SpecialiteJardinier> getAllSpecialiteJardinierBySpecialite(Specialite s) throws SQLException{
        
        ArrayList<SpecialiteJardinier> ar= new ArrayList<>();    
        String req = "SELECT `idSpecialiteJadinier`, `tarif` FROM `specialitejadinier` WHERE `idSpecialite`=?";
        PreparedStatement pstm = cnx.prepareStatement(req);
        pstm.setInt(1, s.getIdSpecialite());
        ResultSet result= pstm.executeQuery();
        while(result.next()){
            ar.add(new SpecialiteJardinier(result.getInt("idSpecialite"), result.getDouble("tarif"), result.getString("description")));
        }
        return ar;  
    }
}
