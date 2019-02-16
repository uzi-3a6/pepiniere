/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.MyDBcon;
import Entities.ReservationEvenement;
import Entities.Stand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class ReservationEvenementService {
    
   Connection ds;

    public ReservationEvenementService() throws SQLException {
         ds = MyDBcon.getInstance().getCnx();
    }
     
       public int insererReservationEvenement (ReservationEvenement re)
    {
        int test=0;
        String req2 = "SELECT nbPlace  FROM evenement WHERE idEvenement =? ";
        try { 
            PreparedStatement ste = ds.prepareStatement(req2) ;
            ste.setInt(1,re.getIdEvenement()) ; 
            ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            
                    if(result.getInt("nbPlace")==0)  
                    {
                        String req1="UPDATE evenement SET etat=? WHERE idEvenement =?" ; 
                          try { 
                                PreparedStatement stee = ds.prepareStatement(req1) ;
             
           
                                
        
                                stee.setString(1,"compler");
                                stee.setInt(2,re.getIdEvenement());
            
                                stee.executeUpdate() ; 
            
                                } catch (SQLException ex) {
                                }
                        System.out.println("l'evenement est complet");
                        return 1;
                    }
                    else if(result.getInt("nbPlace")< re.getNbPersonnes())
                    {System.out.println("nb place demandee est superieur au nombre diponible");
                    return 2 ;
                    }
                    else
                    {
                        String req="INSERT INTO reservationevenement (idEvenement,idUser,dateReservation,nbPersonnes) VALUES(?,?,?,?)" ; 
        try { 
            PreparedStatement stee = ds.prepareStatement(req) ;
             
            stee.setInt(1,re.getIdEvenement()) ; 
            stee.setInt(2,re.getIdUser()) ; 
            stee.setDate(3,re.getDateReservation()) ; 
            stee.setInt(4,re.getNbPersonnes());
           
            
            stee.executeUpdate() ; 
                    System.out.println("ajouter avec succee");
             
            
        } catch (SQLException ex) {
        }
    
        String req1="UPDATE evenement SET nbPlace=nbPlace-? WHERE idEvenement =?" ; 
        try { 
            PreparedStatement stee = ds.prepareStatement(req1) ;
             
           
            stee.setInt(1,re.getNbPersonnes());
        
            
            stee.setInt(2,re.getIdEvenement());
            
            stee.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
                    }
                                    
            ; 
            }
            
        } catch (SQLException ex) {
            
        }
        
        
        
    
    
        return 0;
    }
       public void updateReservationEvenement (ReservationEvenement re)
    {
    String req="UPDATE reservationevenement SET idEvenement=?,idUser=?,dateReservation=?,nbPersonnes=? WHERE idReservationEvenement =?" ; 
        try { 
            PreparedStatement ste = ds.prepareStatement(req) ;
             
            ste.setInt(1,re.getIdEvenement()) ; 
            ste.setInt(2,re.getIdUser()) ; 
            ste.setDate(3,re.getDateReservation()) ; 
            ste.setInt(4,re.getNbPersonnes());
        
            
            ste.setInt(5,re.getIdReservationEvenement());
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
       
       public void DeleteReservationEvenementById (int re)
    {
    String req="DELETE  from reservationevenement where  idReservationEvenement =?" ; 
        try { 
            PreparedStatement ste = ds.prepareStatement(req) ;
             
            
            ste.setInt(1,re) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
       
      public List<ReservationEvenement> selectReservationEvenement ()
    {
        List<ReservationEvenement> list =new ArrayList<>() ; 
    String req ; 
        req = "SELECT *  FROM reservationevenement ";
        try { 
            PreparedStatement ste = ds.prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new ReservationEvenement(
                                    result.getInt("idReservationEvenement"),
                                    result.getInt("idEvenement"),
                                    result.getInt("idUser"),
                                    result.getDate("dateReservation"),
                                    result.getInt("nbPersonnes")
            )); 
            }
            
        } catch (SQLException ex) {
            
        }
    return list ; 
      } 
       
      public int verifReservationEvenement (int e,int re)
    {
        String req ; 
        req = "SELECT *  FROM reservationevenement ";
        try { 
            PreparedStatement ste = ds.prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            if((result.getInt("idEvenement")==e)&&(result.getInt("idUser")==re)) 
            {
                return 1 ;
            }
           
            }
            
        } catch (SQLException ex) {
            
        }
        
        
        
    return 0;
    }
      
     
     
}
