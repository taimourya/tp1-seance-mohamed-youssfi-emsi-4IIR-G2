package com.example.tp.metier;

import com.example.tp.Model.Patient;
import com.example.tp.dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientMetierBD implements IPatientMetier{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient consulterPatient(Long id) {
        Optional<Patient> p = patientRepository.findById(id);
        if(p.isEmpty())
            throw new RuntimeException("Patient introuvable");
        return p.get();
    }

    @Override
    public Collection<Patient> consulterAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void ajouterPatient(String nom, Date dateNaissance, int score, boolean malade) {
        Patient patient = new Patient(nom, dateNaissance, score, malade);
        patientRepository.save(patient);
    }

    @Override
    public void modifierPatient(Long id, String nom, Date dateNaissance, int score, boolean malade) {
        Patient patient = consulterPatient(id);
        patient.setNom(nom);
        patient.setDateNaissance(dateNaissance);
        patient.setScore(score);
        patient.setMalade(malade);
        patientRepository.save(patient);
    }

    @Override
    public void supprimerPatient(Long id) {
        patientRepository.delete(consulterPatient(id));
    }
}
