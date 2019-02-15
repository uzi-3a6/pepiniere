/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyDBcon;
import Entities.Evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Firas
 */



public class EvenementService {
     Connection ds;

    public EvenementService() throws SQLException {
         ds = MyDBcon.getInstance().getCnx();
    }
    
    public void insererEvenement (Evenement e)
    {
    String req="INSERT INTO evenement (nomEvenement,idCategorieEvenement,dateDebut,dateFin,etat,nbPlace,nbStand,prix,image) VALUES(?,?,?,?,?,?,?,?,?)" ; 
        try { 
            PreparedStatement ste = ds.prepareStatement(req) ;
             
            ste.setString(1,e.getNomEvenement()) ; 
            ste.setString(2,e.getIdCategorieEvenement()) ; 
            ste.setDate(3,e.getDateDebut());
            ste.setDate(4,e.getDateFin());
            ste.setString(5,e.getEtat());
            ste.setInt(6,e.getNbPlace());
            ste.setInt(7,e.getNbStand());
            ste.setDouble(8,e.getPrix());
            ste.setString(9,e.getImage());
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
    public void updateEvenement (Evenement e)
    {
    String req="UPDATE evenement SET nomEvenement=?,idCategorieEvenement=?,dateDebut=?,dateFin=?,etat=?,nbPlace=?,nbStand=?,prix=?,image=? WHERE idEvenement =?" ; 
        try { 
            PreparedStatement ste = ds.prepareStatement(req) ;
             
            ste.setString(1,e.getNomEvenement()) ; 
            ste.setString(2,e.getIdCategorieEvenement()) ; 
            ste.setDate(3,e.getDateDebut());
            ste.setDate(4,e.getDateFin());
            ste.setString(5,e.getEtat());
            ste.setInt(6,e.getNbPlace());
            ste.setInt(7,e.getNbStand());
            ste.setDouble(8,e.getPrix());
            ste.setString(9,e.getImage());
            
            ste.setInt(10,e.getIdEvenement());
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
    public void DeleteEvenementById (int e)
    {
    String req="DELETE  from evenement where  idEvenement =?" ; 
        try { 
            PreparedStatement ste = ds.prepareStatement(req) ;
             
            
            ste.setInt(1,e) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
    
    public List<Evenement> selectEvenement ()
    {
        List<Evenement> list =new ArrayList<>() ; 
    String req ; 
        req = "SELECT *  FROM evenement ";
        try { 
            PreparedStatement ste = ds.prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new Evenement(
                                    result.getInt("idEvenement"),
                                    result.getString("nomEvenement"),
                                    result.getString("idCategorieEvenement"),
                                    result.getDate("dateDebut"),
                                    result.getDate("dateFin"),
                                    result.getString("etat"),
                                    result.getInt("nbPlace"),
                                    result.getInt("nbStand"),
                                    result.getInt("prix"),
                                    result.getString("image")
            )); 
            }
            
        } catch (SQLException ex) {
            
        }
    return list ; 
      }
    
    
    
    
    
}
