/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class Stand {
private int idStand;
private int numeroStand;
private int idEvenement;
private int idUser;
private String image;


    public Stand(int idStand, int numeroStand, int idEvenement, int idUser,String image) {
        this.idStand = idStand;
        this.numeroStand = numeroStand;
        this.idEvenement = idEvenement;
        this.idUser = idUser;
        this.image=image;
    }

    public Stand(int numeroStand, int idEvenement, int idUser,String image) {
        this.numeroStand = numeroStand;
        this.idEvenement = idEvenement;
        this.idUser = idUser;
        this.image=image;
    }

    public int getIdStand() {
        return idStand;
    }

    public void setIdStand(int idStand) {
        this.idStand = idStand;
    }

    public int getNumeroStand() {
        return numeroStand;
    }

    public void setNumeroStand(int numeroStand) {
        this.numeroStand = numeroStand;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Stand{" + "idStand=" + idStand + ", numeroStand=" + numeroStand + ", idEvenement=" + idEvenement + ", idUser=" + idUser + ", image=" + image + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idStand;
        hash = 59 * hash + this.numeroStand;
        hash = 59 * hash + this.idEvenement;
        hash = 59 * hash + this.idUser;
        hash = 59 * hash + Objects.hashCode(this.image);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stand other = (Stand) obj;
        if (this.idStand != other.idStand) {
            return false;
        }
        if (this.numeroStand != other.numeroStand) {
            return false;
        }
        if (this.idEvenement != other.idEvenement) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }
    
    

    
    


    
}
