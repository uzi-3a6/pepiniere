/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.ArrayList;

/**
 *
 * @author zorgati
 */
public class Specialite {
    
    private int idSpecialite;
    private String nom;
    
    private ArrayList<SpecialiteJardinier> specialites;

    public Specialite(int idSpecialite, String nom) {
        this.idSpecialite = idSpecialite;
        this.nom = nom;
    }
    
    public Specialite( String nom) {
        
        this.nom = nom;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void ajouterListSpecialiteJardinier(ArrayList<SpecialiteJardinier> spjs){
        specialites.addAll(spjs);
    }

    @Override
    public String toString() {
        return "Specialite{" + "idSpecialite=" + idSpecialite + ", nom=" + nom + ", specialites=" + specialites + '}';
    }
    
    
}
