package com.example.tp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date dateNaissance;
    private int score;
    private boolean malade;

    public Patient(String nom, Date dateNaissance, int score, boolean malade) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.score = score;
        this.malade = malade;
    }
}
