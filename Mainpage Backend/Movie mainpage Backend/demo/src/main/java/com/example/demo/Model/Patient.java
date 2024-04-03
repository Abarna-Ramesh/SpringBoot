package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patient {
    @Id
    private int patientId;
    private String patientName;
    private int age;
    private String gender;
    private String dateOfAppointment;
    private String email;
    private String phoneNumber;
    public Patient() {
    }
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDateOfAppointment() {
        return dateOfAppointment;
    }
    public void setDateOfAppointment(String dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Patient(int patientId, String patientName, int age, String gender, String dateOfAppointment, String email,
            String phoneNumber) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.dateOfAppointment = dateOfAppointment;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    
   
   
    
}