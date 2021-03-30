package com.example.tp;

import com.example.tp.Model.Patient;
import com.example.tp.dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.util.Date;

@SpringBootApplication
public class TpApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(TpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        patientRepository.save(new Patient("yaya", new Date(), 100, true));
        patientRepository.save(new Patient("amza", new Date(), 100, true));
        patientRepository.save(new Patient("amine", new Date(), 100, true));
        patientRepository.save(new Patient("aaaa", new Date(), 100, true));

        patientRepository.findAll().forEach(patient -> System.out.println(patient));
    }


}
