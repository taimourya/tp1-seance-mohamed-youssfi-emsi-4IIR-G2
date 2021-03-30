package com.example.tp;

import com.example.tp.Model.Patient;
import com.example.tp.dao.PatientRepository;
import com.example.tp.metier.IPatientMetier;
import com.example.tp.metier.PatientMetierBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.util.Date;

@SpringBootApplication
public class TpApplication implements CommandLineRunner {

    @Autowired
    private IPatientMetier patientMetier;

    public static void main(String[] args) {
        SpringApplication.run(TpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientMetier.ajouterPatient("yahya", new Date(), 100, true);
        patientMetier.ajouterPatient("hamza", new Date(), 250, true);
        patientMetier.ajouterPatient("amine", new Date(), 200, false);
        patientMetier.ajouterPatient("moqtad", new Date(), 150, true);

        patientMetier.modifierPatient(new Long(2), "hattab", new Date(), 200, false);
        patientMetier.supprimerPatient(new Long(4));

        patientMetier.consulterAllPatients().forEach(patient -> System.out.println(patient));
    }


}
