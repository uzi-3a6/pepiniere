/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.sql.Date;

/**
 *
 * @author zorgati
 */
public final class TravailJardinage {
    
    private int idTravail;
    private Date dateTravail;
    private Adresse adresse;
    private int nbHeursTravail;
    private int etatPaiement;
    private int noteTravail;
    
    private Jardinier jardinier;
    private User user;

    public TravailJardinage(int idTravail, Date dateTravail, Adresse adresse, int nbHeursTravail, int etatPaiement, int noteTravail) {
        this.idTravail = idTravail;
        this.dateTravail = dateTravail;
        this.adresse = adresse;
        this.nbHeursTravail = nbHeursTravail;
        this.etatPaiement = etatPaiement;
        this.noteTravail = noteTravail;
        //this.jardinier = jardinier;
        //this.user = user;
    }
    
    public TravailJardinage(Date dateTravail, Adresse adresse, int nbHeursTravail, int etatPaiement, int noteTravail) {
        this.idTravail = idTravail;
        this.dateTravail = dateTravail;
        this.adresse = adresse;
        this.nbHeursTravail = nbHeursTravail;
        this.etatPaiement = etatPaiement;
        this.noteTravail = noteTravail;
        //this.jardinier = jardinier;
        //this.user = user;
    }

    public int getIdTravail() {
        return idTravail;
    }

    public void setIdTravail(int idTravail) {
        this.idTravail = idTravail;
    }

    public Date getDateTravail() {
        return dateTravail;
    }

    public void setDateTravail(Date dateTravail) {
        this.dateTravail = dateTravail;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public int getNbHeursTravail() {
        return nbHeursTravail;
    }

    public void setNbHeursTravail(int nbHeursTravail) {
        this.nbHeursTravail = nbHeursTravail;
    }

    public int getEtatPaiement() {
        return etatPaiement;
    }

    public void setEtatPaiement(int etatPaiement) {
        this.etatPaiement = etatPaiement;
    }

    public int getNoteTravail() {
        return noteTravail;
    }

    public void setNoteTravail(int noteTravail) {
        this.noteTravail = noteTravail;
    }

    public Jardinier getJardinier() {
        return jardinier;
    }

    public void setJardinier(Jardinier jardinier) {
        this.jardinier = jardinier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    
    
}
