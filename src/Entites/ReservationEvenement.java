/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class ReservationEvenement {
    
    private int idReservationEvenement;
    private int idEvenement;
    private int idUser;
    private Date dateReservation;
    private int nbPersonnes;

    public ReservationEvenement(int idReservationEvenement, int idEvenement, int idUser, Date dateReservation, int nbPersonnes) {
        this.idReservationEvenement = idReservationEvenement;
        this.idEvenement = idEvenement;
        this.idUser = idUser;
        this.dateReservation = dateReservation;
        this.nbPersonnes = nbPersonnes;
    }

    public ReservationEvenement(int idEvenement, int idUser, Date dateReservation, int nbPersonnes) {
        this.idEvenement = idEvenement;
        this.idUser = idUser;
        this.dateReservation = dateReservation;
        this.nbPersonnes = nbPersonnes;
    }

    public int getIdReservationEvenement() {
        return idReservationEvenement;
    }

    public void setIdReservationEvenement(int idReservationEvenement) {
        this.idReservationEvenement = idReservationEvenement;
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

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    @Override
    public String toString() {
        return "ReservationEvenement{" + "idReservationEvenement=" + idReservationEvenement + ", idEvenement=" + idEvenement + ", idUser=" + idUser + ", dateReservation=" + dateReservation + ", nbPersonnes=" + nbPersonnes + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idReservationEvenement;
        hash = 67 * hash + this.idEvenement;
        hash = 67 * hash + this.idUser;
        hash = 67 * hash + Objects.hashCode(this.dateReservation);
        hash = 67 * hash + this.nbPersonnes;
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
        final ReservationEvenement other = (ReservationEvenement) obj;
        if (this.idReservationEvenement != other.idReservationEvenement) {
            return false;
        }
        if (this.idEvenement != other.idEvenement) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.nbPersonnes != other.nbPersonnes) {
            return false;
        }
        if (!Objects.equals(this.dateReservation, other.dateReservation)) {
            return false;
        }
        return true;
    }
    
    
    
}
