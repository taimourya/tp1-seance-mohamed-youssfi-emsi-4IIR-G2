package com.example.tp.metier;

import com.example.tp.Model.Patient;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

public interface IPatientMetier {
    Patient consulterPatient(Long id);
    Collection<Patient> consulterAllPatients();
    void ajouterPatient(String nom, Date dateNaissance, int score, boolean malade);
    void modifierPatient(Long id, String nom, Date dateNaissance, int score, boolean malade);
    void supprimerPatient(Long id);
}
