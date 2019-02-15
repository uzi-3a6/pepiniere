/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.Objects;

/**
 *
 * @author zorgati
 */
public class Adresse{
    private int idAdresse;
    private String gouvernorat;
    private int codePostale;
    private String Citee;
    private String rue;
    private int numero;
    private String description;

    public Adresse(int idAdresse, String gouvernorat, int codePostale, String Citee, String rue, int numero, String description) {
        this.idAdresse = idAdresse;
        this.gouvernorat = gouvernorat;
        this.codePostale = codePostale;
        this.Citee = Citee;
        this.rue = rue;
        this.numero = numero;
        this.description = description;
    }
    
    public Adresse(String gouvernorat, int codePostale, String Citee, String rue, int numero, String description) {
        this.gouvernorat = gouvernorat;
        this.codePostale = codePostale;
        this.Citee = Citee;
        this.rue = rue;
        this.numero = numero;
        this.description = description;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    private void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getCitee() {
        return Citee;
    }

    public void setCitee(String Citee) {
        this.Citee = Citee;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idAdresse;
        hash = 97 * hash + Objects.hashCode(this.gouvernorat);
        hash = 97 * hash + this.codePostale;
        hash = 97 * hash + Objects.hashCode(this.Citee);
        hash = 97 * hash + Objects.hashCode(this.rue);
        hash = 97 * hash + this.numero;
        hash = 97 * hash + Objects.hashCode(this.description);
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
        final Adresse other = (Adresse) obj;
        if (this.idAdresse != other.idAdresse) {
            return false;
        }
        if (this.codePostale != other.codePostale) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.gouvernorat, other.gouvernorat)) {
            return false;
        }
        if (!Objects.equals(this.Citee, other.Citee)) {
            return false;
        }
        if (!Objects.equals(this.rue, other.rue)) {
            return false;
        }
        return Objects.equals(this.description, other.description);
    }

    @Override
    public String toString() {
        return "Adresse{" + "idAdresse=" + idAdresse + ", gouvernorat=" + gouvernorat + ", codePostale=" + codePostale + ", Citee=" + Citee + ", rue=" + rue + ", numero=" + numero + ", description=" + description + '}';
    }
    
}
