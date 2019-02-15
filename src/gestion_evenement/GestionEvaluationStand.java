/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_evenement;

import Entities.EvaluationStand;
import services.EvaluationStandService;




/**
 *
 * @author Admin
 */
public class GestionEvaluationStand {
     public static void main(String[] args) {
        EvaluationStand es1= new EvaluationStand(3, 2, 8);
         EvaluationStand es2= new EvaluationStand(3,1, 1, 5);
      
        /* int test=EvaluationStandService.insererEvaluationStand(es1);
         if(test==0)
         {System.out.println("ajouter avec sucee");}
         else{System.out.println("vous aver deja evaluer le stand");}
          */
       //EvaluationStandService.updateEvaluationStand(es2);
       
      //EvaluationStandService.DeleteEvenementById(2);
         
          
        // EvaluationStandService.selectEvaluationStand().forEach((es)->{System.out.println(es);});
        
      
       /*float moyenne;
       moyenne= EvaluationStandService.CalculeMoyByStand(3);
       System.out.println(moyenne);
*/
                                     
       
       
      
}
}