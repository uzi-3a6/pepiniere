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
public class User {
    
    protected int id;
    protected String username;
    protected String email;
    protected boolean enabled;
    private String password;
    protected Date lastLogin;
    private String confirmationToken;
    protected int role;
    protected String nom;
    protected String prenom;
    protected Adresse adresse;
    protected String telephone;
    

    public User(int id, String username, String email, boolean enabled, String password, Date lastLogin, int role, String nom, String prenom, Adresse adresse , String telephone) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.lastLogin = lastLogin;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone= telephone;
    }
    
    public User(String username, String email, boolean enabled, String password, Date lastLogin, int role, String nom, String prenom, Adresse adresse, String telephone) {
        
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.lastLogin = lastLogin;
        
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    

   

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + ", enabled=" + enabled + ", password=" + password + ", lastLogin=" + lastLogin + ", role=" + role + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }
    
    
    
}
