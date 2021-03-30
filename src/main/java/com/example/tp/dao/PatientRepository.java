package com.example.tp.dao;


import com.example.tp.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p where p.nom = ?1")
    Patient findPatientByNom(String nom);
}
