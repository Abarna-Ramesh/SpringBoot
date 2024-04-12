package com.example.demo.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Patient;

public interface PatientRepo extends JpaRepository<Patient,Integer>{
    @Query("SELECT f FROM Patient f WHERE f.gender='female'")
    List<Patient> findByGender();

    
}