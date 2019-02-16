/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_evenement;

import Entities.Evenement;
import java.sql.Date;
import java.sql.SQLException;
import services.EvenementService;

/**
 *
 * @author Admin
 */
public class Gestion_evenement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Evenement e1 =new Evenement("nos5a 24 men boutoulet el rabta", "Familiale",new Date (1996,7,7), new Date (1997,10,10), "en attente", 200,200, 400,"firas");
        Evenement e2 =new Evenement(14,"Competition", "couple exiger",new Date (1996,7,7), new Date (1997,10,10), "en attente", 200,300, 500,"pidev");
        EvenementService es =new EvenementService();

    //  es.insererEvenement(e1);
          
       
   //   es.DeleteEvenementById(18);
      
      
      
  //   es.updateEvenement(e2);
      
      
     es.selectEvenement().forEach((t)->{System.out.println(t);});
        
      
    }
    
}
