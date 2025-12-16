package com.zela.app.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private int id;
    private String nom;
    private String prenom;

    public User(int id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
    }

    public User(String nom, String prenom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide");
        }
        if (prenom == null || prenom.isBlank()) {
            throw new IllegalArgumentException("Le prénom ne peut pas être vide");
        }
        this.nom = nom;
        this.prenom = prenom;
    }

    public User(ResultSet resultSet) throws SQLException {
        id = resultSet.getInt("id");
        prenom = resultSet.getString("prenom");
        nom = resultSet.getString("nom");
    }

    public User() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
