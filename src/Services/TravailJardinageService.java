/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DB.MyDBcon;
import Entites.Adresse;
import Entites.Jardinier;
import Entites.TravailJardinage;
import Entites.User;
import java.sql.Connection;
import java.sql.Date;
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
public class TravailJardinageService {
    Connection cnx;
    
    public TravailJardinageService() throws SQLException{
        cnx = MyDBcon.getInstance().getCnx();
    }
    public int ajouterTravailJardinage(TravailJardinage t){
        
        try {
             
             String req = "INSERT INTO `travailjadinage`(`dateTravail`, `adress`, `etatTravail`, `etatPaiement`, `idJardiner`, `idUser`) VALUES (?,?,?,?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
             pstm.setDate(1, t.getDateTravail());
             pstm.setInt(2, t.getAdresse().getIdAdresse());
             pstm.setInt(3, t.getIdTravail());
             pstm.setInt(4,t.getEtatPaiement());
             pstm.setInt(5,t.getJardinier().getId());
             pstm.setInt(6,t.getUser().getId());
             pstm.executeUpdate();
             ResultSet result = pstm.getGeneratedKeys();
             if(result.next())return result.getInt(1);
         } catch (SQLException ex) {
             Logger.getLogger(TravailJardinageService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return -1;
    }
    
    public void modifierTravailJardinage(TravailJardinage t){
        
        try {
             
             String req = "UPDATE `travailjadinage` SET `dateTravail`=?,`adress`=?,`nbHeursTravail`=?,`etatPaiement`=?,`noteTravail`=?,`idJardiner`=?,`idUser`=? WHERE `idTravailJadinage`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setDate(1, t.getDateTravail());
             pstm.setInt(2, t.getAdresse().getIdAdresse());
             pstm.setInt(3, t.getIdTravail());
             pstm.setInt(4,t.getEtatPaiement());
             pstm.setInt(5,t.getJardinier().getId());
             pstm.setInt(6,t.getUser().getId());
             pstm.setInt(7,t.getIdTravail());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(TravailJardinageService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    public void supprimerTravailJardinage(TravailJardinage t){
        
        try {
             
             String req = "DELETE FROM `travailjadinage` WHERE `idTravailJadinage`=?";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1,t.getIdTravail());
             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(TravailJardinageService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    public TravailJardinage getTravailJardinageById(int idtj) throws SQLException{

        String req = "SELECT tj.*,ad.* FROM travailjadinage tj "
                + "inner join adresse ad on tj.adress=ad.idAdresse"
                + "where idTravailjardinier=?";
        PreparedStatement pstm = cnx.prepareStatement(req);
        pstm.setInt(1, idtj);
        ResultSet result=pstm.executeQuery();
        if(!result.next()){
            return null;
        }
        int idTravail = result.getInt("idTravailJadinage");
        Date dateTravail = result.getDate("dateTravail");
       
        Adresse adresse = new Adresse(result.getInt("idAdresse"), result.getString("gouvernorat"), result.getInt("codePostale"),result.getString("citee"), result.getString("rue"), result.getInt("numero"), result.getString("description"));
        int nbHeursTravail = result.getInt("nbHeursTravail");
        int etatPaiement = result.getInt("etatPaiement");
        int noteTravail = result.getInt("noteTravail"); 
        
        return new TravailJardinage(idTravail, dateTravail, adresse, nbHeursTravail, etatPaiement, noteTravail);
    }
    
    
    public ArrayList<TravailJardinage> getAllTravailJardinage() throws SQLException{
        ArrayList<TravailJardinage> arr= new ArrayList<>();
        String req = "SELECT tj.*,ad.* FROM travailjadinage tj "
                + "inner join adresse ad on tj.adress=ad.idAdresse";
        PreparedStatement pstm = cnx.prepareStatement(req);
        ResultSet result=pstm.executeQuery();
        while(result.next()){
            int idTravail = result.getInt("idTravailJadinage");
            Date dateTravail = result.getDate("dateTravail");
            Adresse adresse = new Adresse(result.getInt("idAdresse"), result.getString("gouvernorat"), result.getInt("codePostale"),result.getString("citee"), result.getString("rue"), result.getInt("numero"), result.getString("description"));
            int nbHeursTravail = result.getInt("nbHeursTravail");
            int etatPaiement = result.getInt("etatPaiement");
            int noteTravail = result.getInt("noteTravail");
            arr.add(new TravailJardinage(idTravail, dateTravail, adresse, nbHeursTravail, etatPaiement, noteTravail));
        }
        return arr;
    }
    public ArrayList<TravailJardinage> getAllTravailJardinageByJardinier(Jardinier j) throws SQLException{
        ArrayList<TravailJardinage> arr= new ArrayList<>();
        String req = "SELECT tj.*,ad.* FROM travailjadinage tj "
                + "inner join adresse ad on tj.adress=ad.idAdresse"
                + "where idJardinier=?";
                
        PreparedStatement pstm = cnx.prepareStatement(req);
        pstm.setInt(1, j.getId());
        ResultSet result=pstm.executeQuery();
        while(result.next()){
            int idTravail = result.getInt("idTravailJadinage");
            Date dateTravail = result.getDate("dateTravail"); 
            Adresse adresse = new Adresse(result.getInt("idAdresse"), result.getString("gouvernorat"), result.getInt("codePostale"),result.getString("citee"), result.getString("rue"), result.getInt("numero"), result.getString("description"));
            int nbHeursTravail = result.getInt("nbHeursTravail");
            int etatPaiement = result.getInt("etatPaiement");
            int noteTravail = result.getInt("noteTravail");
            arr.add(new TravailJardinage(idTravail, dateTravail, adresse, nbHeursTravail, etatPaiement, noteTravail));
        }
        return arr;
    }
    
    public ArrayList<TravailJardinage> getAllTravailJardinageByUser(User u) throws SQLException{
        ArrayList<TravailJardinage> arr= new ArrayList<>();
        String req = "SELECT tj.*,ad.* FROM travailjadinage tj "
                + "inner join adresse ad on tj.adress=ad.idAdresse"
                + "where idUser=?";
                
        PreparedStatement pstm = cnx.prepareStatement(req);
        pstm.setInt(1, u.getId());
        ResultSet result=pstm.executeQuery();
        while(result.next()){
            int idTravail = result.getInt("idTravailJadinage");
            Date dateTravail = result.getDate("dateTravail"); 
            Adresse adresse = new Adresse(result.getInt("idAdresse"), result.getString("gouvernorat"), result.getInt("codePostale"),result.getString("citee"), result.getString("rue"), result.getInt("numero"), result.getString("description"));
            int nbHeursTravail = result.getInt("nbHeursTravail");
            int etatPaiement = result.getInt("etatPaiement");
            int noteTravail = result.getInt("noteTravail");
            arr.add(new TravailJardinage(idTravail, dateTravail, adresse, nbHeursTravail, etatPaiement, noteTravail));
        }
        return arr;
    }
    
    public double getNoteJardinier(Jardinier j) throws SQLException{
       
        String req = "SELECT AVG(noteTravail) FROM `travailjadinage` WHERE idJardiner=?";
        PreparedStatement pstm = cnx.prepareStatement(req);
        pstm.setInt(1, j.getId());
        ResultSet result=pstm.executeQuery();
        if(!result.next()){
            return 0;
        }
        return result.getDouble(1);

    }
    
}
