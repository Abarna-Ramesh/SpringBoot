package com.example.myfirstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myfirstproject.patiententity.PatientEntity;

public interface PatientRepo extends JpaRepository<PatientEntity,Integer>{

}