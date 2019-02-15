/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_evenement;

import Entities.Stand;
import services.StandService;
import sun.applet.Main;

/**
 *
 * @author Admin
 */
public class GestionStand {
    
    public static void main(String[] args) {
        Stand s1= new Stand(4, 0, 0,"firas development center 2019");
      
          Stand s2= new Stand(4,3, 0, 5,"ab3ad");
          
           //StandService.insererStand(s1);
          
           //StandService.updateStand(s2);
           
          // StandService.DeleteStandById(2);
          
           //StandService.selectStand().forEach((s)->{System.out.println(s);});
           
           
          
    }
}
