/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_evenement;

import Entities.Stand;
import java.sql.SQLException;
import services.StandService;
import sun.applet.Main;

/**
 *
 * @author Admin
 */
public class GestionStand {
    
    public static void main(String[] args) throws SQLException {
        Stand s1= new Stand(4, 0, 0,"firas development center 2019");
      
          Stand s2= new Stand(4,3, 0, 5,"ab3ad");
          
          StandService ss =new StandService();
           


         //  ss.insererStand(s1);
          
       //    ss.updateStand(s2);
           
        //  ss.DeleteStandById(2);
          
       //    ss.selectStand().forEach((s)->{System.out.println(s);});
           
           
          
    }
}
