/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_evenement;

import Entities.ReservationEvenement;
import Entities.Stand;
import java.sql.Date;
import java.sql.SQLException;
import services.ReservationEvenementService;

/**
 *
 * @author Admin
 */
public class GestionReservationEvenement {
    
    
    public static void main(String[] args) throws SQLException {
        ReservationEvenement re1 =new ReservationEvenement(18, 3, new Date (1996,7,7), 1);
        ReservationEvenement re2 =new ReservationEvenement(1,1, 4, new Date (1996,7,7), 40);
        ReservationEvenementService res =new ReservationEvenementService();
       
        
      //  res.insererReservationEvenement(re1);
        
        
     //   res.updateReservationEvenement(re2);
     
        
        
     //   res.DeleteReservationEvenementById(1);
          
      //  res.selectReservationEvenement().forEach((s)->{System.out.println(s);});
           
           
          
    }
}
