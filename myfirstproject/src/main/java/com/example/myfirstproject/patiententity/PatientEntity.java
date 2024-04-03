package com.example.myfirstproject.patiententity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PatientEntity {

    @Id
    private int pid;
    private String pname;
    private String password;
    
    public PatientEntity(int pid, String pname, String password) {
        this.pid = pid;
        this.pname = pname;
        this.password = password;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public PatientEntity() {
    }
    
    

}