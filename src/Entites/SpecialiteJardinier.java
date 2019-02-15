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


public class SpecialiteJardinier {
    
    private int idSpecialiteJardinier;
    private double tarif;
    private String description;
    
    private Jardinier jardinier;
    private Specialite specialite;

    public SpecialiteJardinier(int idSpecialiteJardinier, double tarif, String description) {
        this.idSpecialiteJardinier = idSpecialiteJardinier;
        this.tarif = tarif;
        this.description = description;
        //this.jardinier = jardinier;
        //this.specialite = specialite;
    }
    
    public SpecialiteJardinier(double tarif, String description) {
        this.tarif = tarif;
        this.description = description;
        //this.jardinier = jardinier;
        //this.specialite = specialite;
    }

    public int getIdSpecialiteJardinier() {
        return idSpecialiteJardinier;
    }

    public void setIdSpecialiteJardinier(int idSpecialiteJardinier) {
        this.idSpecialiteJardinier = idSpecialiteJardinier;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Jardinier getJardinier() {
        return jardinier;
    }

    public void setJardinier(Jardinier jardinier) {
        this.jardinier = jardinier;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return "SpecialiteJardinier{" + "idSpecialiteJardinier=" + idSpecialiteJardinier + ", tarif=" + tarif + ", description=" + description + ", jardinier=" + jardinier + ", specialite=" + specialite + '}';
    }
    
    
    
    
    
}
