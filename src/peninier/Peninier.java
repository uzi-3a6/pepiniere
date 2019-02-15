/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peninier;

import Entites.Adresse;
import Entites.Jardinier;
import Entites.Specialite;
import Entites.SpecialiteJardinier;
import Entites.TravailJardinage;
import Entites.User;
import Services.AdresseService;
import Services.JardinerService;
import Services.SpecialiteService;
import Services.TravailJardinageService;
import Services.UserService;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author zorgati
 */
public class Peninier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Adresse ad = new Adresse("tunis", 1004, "Menzah", "rue horia,immd balkis", 5, "bah4a markez");
        
        //User u1= new User(5, "achraf", "achraf@gmail", true, "achraf", 0, Date.valueOf(LocalDate.now()), "achraf", "zorgati", ad);
        
        ArrayList<Jardinier.Jours> jours = new ArrayList<>(Arrays.asList(Jardinier.Jours.DIMANCHE,Jardinier.Jours.JEUDI));
        
        Jardinier j =new Jardinier(1,"achraff", "achraf@gmail.com", true, "achraf",  Date.valueOf(LocalDate.now()),3, "achraf", "zorgati", ad,"+216 92 642 976","blabla", jours);
        
        Specialite sp = new Specialite(1,"Tondre");
        
        SpecialiteJardinier spj = new SpecialiteJardinier(5, "gazon special");
        
        //TravailJardinage tr= new TravailJardinage(new Date(2019, 6, 2), ad, 0, 0, 0, j, u1);
        
        
        
        JardinerService js= new JardinerService();
        //js.ajouterJardinier(j);
        
        TravailJardinageService trs= new TravailJardinageService();
        //trs.ajouterTravailJardinier(tr);
        
        AdresseService as= new AdresseService();
        
        //as.ajouterAdresse(ad);
        //System.out.println(as.chercherAdresse(1));
        //SpecialiteJardinierService sps = new SpecialiteJardinierService();
        //sps.getSpecialiteJardinier(2).toString();
        
        //SpecialiteService sps = new SpecialiteService();
        //sps.getSpecialite(sp);
        //System.out.println(sp);
        
        UserService us = new UserService();
        //System.out.println(us.inscription(j));
        System.out.println(j.getConfirmationToken());
        
        System.out.println(us.generateToken());
        
        j.setConfirmationToken("123");
        System.out.println(us.verifierToken(j));
        System.out.println(us.authentication("achraff", "achraf"));
        
        
        
        
        j.setConfirmationToken("NF7W8H8");
        
        System.out.println(us.verifierToken(j));
        
        System.out.println(us.authentication("achraff", "achraf"));
    }
    
}
