/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Admin
 */
public class EvaluationStand {
    
    private int idEvaluationStand;
    private int idStand;
    private int idUser;
    private float note;

    public EvaluationStand(int idEvaluationStand, int idStand, int idUser, float note) {
        this.idEvaluationStand = idEvaluationStand;
        this.idStand = idStand;
        this.idUser = idUser;
        this.note = note;
    }

    public EvaluationStand(int idStand, int idUser, float note) {
        this.idStand = idStand;
        this.idUser = idUser;
        this.note = note;
    }

    public int getIdEvaluationStand() {
        return idEvaluationStand;
    }

    public void setIdEvaluationStand(int idEvaluationStand) {
        this.idEvaluationStand = idEvaluationStand;
    }

    public int getIdStand() {
        return idStand;
    }

    public void setIdStand(int idStand) {
        this.idStand = idStand;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "EvaluationStand{" + "idEvaluationStand=" + idEvaluationStand + ", idStand=" + idStand + ", idUser=" + idUser + ", note=" + note + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idEvaluationStand;
        hash = 89 * hash + this.idStand;
        hash = 89 * hash + this.idUser;
        hash = 89 * hash + Float.floatToIntBits(this.note);
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
        final EvaluationStand other = (EvaluationStand) obj;
        if (this.idEvaluationStand != other.idEvaluationStand) {
            return false;
        }
        if (this.idStand != other.idStand) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        if (Float.floatToIntBits(this.note) != Float.floatToIntBits(other.note)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
