package com.example.demo.Repositary;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Doctor;
// import com.example.demo.Model.Patient;

public interface DoctorRepo extends JpaRepository<Doctor,Integer>{
   

    
}