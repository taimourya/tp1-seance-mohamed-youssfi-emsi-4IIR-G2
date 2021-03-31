package com.example.tp.controller;

import com.example.tp.Model.Patient;
import com.example.tp.metier.IPatientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.Date;

@Controller
public class PatientController {
    @Autowired
    private IPatientMetier patientMetier;

    @GetMapping("/")
    public String patients(Model model, Long id) {

        try {
            if(id != null){
                Patient p = patientMetier.consulterPatient(id);
                model.addAttribute("patient", p);
                model.addAttribute("editMode", true);
            }
            else {
                model.addAttribute("editMode", false);
            }
        } catch (Exception e) {
            model.addAttribute("exception", e);
        }

        Collection<Patient> patients = patientMetier.consulterAllPatients();
        model.addAttribute("patients", patients);


        model.addAttribute("form_title", "Ajouter un patient");

        return "patients";
    }

    @PostMapping("/savePatient")
    public String savePatient(String nom, String dateNaissance, int score, boolean malade){
        patientMetier.ajouterPatient(nom, new Date(), score, malade);
        return "redirect:/";
    }


    @PostMapping("/editPatient")
    public String editPatient(Long id, String nom, String dateNaissance, int score, boolean malade){
        patientMetier.modifierPatient(id, nom, new Date(), score, malade);
        return "redirect:/";
    }
    @GetMapping("/removePatient")
    public String supprimerPatient(Long id){
        patientMetier.supprimerPatient(id);
        return "redirect:/";
    }

}
