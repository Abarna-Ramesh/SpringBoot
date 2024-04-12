package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Doctor {
    @Id
    private int doctorId;
    private int patientId;
    private String dName;
    private String gender;
    public Doctor() {
    }
    public Doctor(int doctorId, int patientId, String dName, String gender) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.dName = dName;
        this.gender = gender;
    }
    public int getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public String getdName() {
        return dName;
    }
    public void setdName(String dName) {
        this.dName = dName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @OneToOne
    @JsonBackReference
    private Patient patient;
    //primary table obj
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
   
    
}