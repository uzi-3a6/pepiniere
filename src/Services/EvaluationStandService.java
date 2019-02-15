/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DB.DB;
import Entities.EvaluationStand;
import Entities.Evenement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static services.EvenementService.ds;

/**
 *
 * @author Admin
 */
public class EvaluationStandService {
    
    static DB ds =DB.getInstance(); 
    
    public static int insererEvaluationStand (EvaluationStand es)
    {
        String req3 ; 
        req3 = "SELECT idUser,idStand  FROM evaluationstand ";
        int test=0;
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req3) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
           
                                  
              int a= result.getInt("idUser");
              int b=result.getInt("idStand");
              if (a==es.getIdUser()&&b==es.getIdStand())
              {test =1;
              }
               
                                   
                                    
            
            }
            
        } catch (SQLException ex) {
            
        }
        
        
        if (test ==0)
        {
    String req="INSERT INTO evaluationstand (idStand,idUser,note) VALUES(?,?,?)" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setInt(1,es.getIdStand()) ; 
            ste.setInt(2,es.getIdUser()) ; 
            ste.setFloat(3,es.getNote());
            
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
        }
        return test;
    }
    
    public static void updateEvaluationStand (EvaluationStand es)
    {
    String req="UPDATE evaluationstand SET idStand=?,idUser=?,note=? WHERE idEvaluationStand =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setInt(1,es.getIdStand()) ; 
            ste.setInt(2,es.getIdUser()) ; 
            ste.setFloat(3,es.getNote());
           
            
            ste.setInt(4,es.getIdEvaluationStand());
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
    public static void DeleteEvenementById (int es)
    {
    String req="DELETE  from evaluationstand where  idEvaluationStand =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setInt(1,es) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
    
    public static List<EvaluationStand> selectEvaluationStand ()
    {
        List<EvaluationStand> list =new ArrayList<>() ; 
    String req ; 
        req = "SELECT *  FROM evaluationstand ";
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new EvaluationStand(
                                    result.getInt("idEvaluationStand"),
                                    result.getInt("idStand"),
                                    result.getInt("idUser"),
                                    result.getFloat("note")
                                    
            )); 
            }
            
        } catch (SQLException ex) {
            
        }
    return list ; 
      }
    
    public static float CalculeMoyByStand (int idStand)
    {  float moyenne = 0;
       int i=0;
    
    String req ; 
        req = "SELECT note  FROM evaluationstand where idStand =?  ";
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
              ste.setInt(1,idStand) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            i++;
                                   
           moyenne=moyenne+result.getFloat("note");
                                    
             
            }
            
        } catch (SQLException ex) {
            
        }
    
        
        moyenne=moyenne/i;
     return moyenne; 
    }
}
