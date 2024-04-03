package com.example.demo.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Patient;

public interface PatientRepo extends JpaRepository<Patient,Integer>{
    
}