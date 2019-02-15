/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_evenement;

import Entities.EvaluationStand;
import java.sql.SQLException;
import services.EvaluationStandService;




/**
 *
 * @author Admin
 */
public class GestionEvaluationStand {
     public static void main(String[] args) throws SQLException {
        EvaluationStand es1= new EvaluationStand(3, 2, 8);
         EvaluationStand es2= new EvaluationStand(3,1, 1, 5);
      EvaluationStandService ess= new EvaluationStandService();
      
      
      
        /* int test=ess.insererEvaluationStand(es1);
         if(test==0)
         {System.out.println("ajouter avec sucee");}
         else{System.out.println("vous aver deja evaluer le stand");}
          */
    
        
     // ess.updateEvaluationStand(es2);
       
     // ess.DeleteEvenementById(2);
         
          
     //  ess.selectEvaluationStand().forEach((es)->{System.out.println(es);});
        
      
       /*float moyenne;
       moyenne= ess.CalculeMoyByStand(3);
       System.out.println(moyenne);*/

                                     
       
       
      
}
}