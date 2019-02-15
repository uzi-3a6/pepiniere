/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.DB;
import Entities.Evenement;
import Entities.Stand;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static services.EvenementService.ds;

/**
 *
 * @author Admin firas
 */
public class StandService {
     static DB ds =DB.getInstance();
     
       public static void insererStand (Stand s)
    {
    String req="INSERT INTO stand (numeroStand,idEvenement,idUser,image) VALUES(?,?,?,?)" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setInt(1,s.getNumeroStand()) ; 
            ste.setInt(2,s.getIdEvenement()) ; 
            ste.setInt(3,s.getIdUser());
            ste.setString(4,s.getImage());
           
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
    public static void updateStand (Stand s)
    {
    String req="UPDATE stand SET numeroStand=?,idEvenement=?,idUser=?,image=? WHERE idStand =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setInt(1,s.getNumeroStand()) ; 
            ste.setInt(2,s.getIdEvenement()) ; 
            ste.setInt(3,s.getIdUser());
            ste.setString(4, s.getImage());
        
            
            ste.setInt(5,s.getIdStand());
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
    public static void DeleteStandById (int s)
    {
    String req="DELETE  from stand where  idStand =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setInt(1,s) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
    
    public static List<Stand> selectStand ()
    {
        List<Stand> list =new ArrayList<>() ; 
    String req ; 
        req = "SELECT *  FROM stand ";
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new Stand(
                                    result.getInt("idStand"),
                                    result.getInt("numeroStand"),
                                    result.getInt("idEvenement"),
                                    result.getInt("idUser"),
                                    result.getString("image")
            )); 
            }
            
        } catch (SQLException ex) {
            
        }
    return list ; 
      }
}
