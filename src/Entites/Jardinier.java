/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author zorgati
 */


public class Jardinier extends User  {
    
    public static enum Jours{
        LUNDI,MARDI,MERCREDI,JEUDI,VENDREDI,SAMDI,DIMANCHE
    }
    //private int idJardinier;
    private String descriptionJardinier;
    private ArrayList<Jours> joursTravails;
    //private Adresse lieuDeTravail;
    
    
    private ArrayList<TravailJardinage> travails;
    private ArrayList<SpecialiteJardinier> specialites;

    public Jardinier(int id, String username, String email, boolean enabled, String password, Date lastLogin, int role, String nom, String prenom, Adresse adresse, String telephone , String descriptionJardinier, ArrayList<Jours> joursTravails) {
        super(id, username, email, enabled, password, lastLogin, role, nom, prenom, adresse, telephone);
        this.descriptionJardinier = descriptionJardinier;
        this.joursTravails = joursTravails;
    }
    
      public Jardinier( String username, String email, boolean enabled, String password, Date lastLogin, int role, String nom, String prenom, Adresse adresse, String telephone,String descriptionJardinier, ArrayList<Jours> joursTravails) {
        super(username, email, enabled, password, lastLogin, role, nom, prenom, adresse, telephone);
        this.descriptionJardinier = descriptionJardinier;
        this.joursTravails = joursTravails;
    }
      
      public Jardinier( User user,String descriptionJardinier, ArrayList<Jours> joursTravails) {
        super(user.getUsername(), user.getEmail(), user.isEnabled(),user.getPassword(), user.getLastLogin(), user.getRole(), user.getNom(), user.getPrenom(), user.getAdresse(), user.getTelephone());
        this.descriptionJardinier = descriptionJardinier;
        this.joursTravails = joursTravails;
    }

    
   

    
    public String getDescriptionJardinier() {
        return descriptionJardinier;
    }

    public void setDescriptionJardinier(String description) {
        this.descriptionJardinier = description;
    }

    public ArrayList<Jours> getJoursTravails() {
        return joursTravails;
    }

    public void setJoursTravails(ArrayList<Jours> joursTravails) {
        this.joursTravails = joursTravails;
    }

    public ArrayList<TravailJardinage> getTravails() {
        return travails;
    }

    public void setTravails(ArrayList<TravailJardinage> travails) {
        this.travails = travails;
    }

    public ArrayList<SpecialiteJardinier> getSpecialites() {
        return specialites;
    }

    public void setSpecialites(ArrayList<SpecialiteJardinier> specialites) {
        this.specialites = specialites;
    }

    @Override
    public String toString() {
        return "Jardinier{" +super.toString()+ "descriptionJardinier=" + descriptionJardinier + ", joursTravails=" + joursTravails + ", travails=" + travails + ", specialites=" + specialites + '}';
    }
    
    
    
    
    
    
    
    
}
 
