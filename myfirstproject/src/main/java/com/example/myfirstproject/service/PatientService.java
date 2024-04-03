package com.example.myfirstproject.service;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myfirstproject.patiententity.PatientEntity;
import com.example.myfirstproject.repository.PatientRepo;

// import jakarta.persistence.metamodel.ListAttribute;

@Service
public class PatientService {

    @Autowired
    PatientRepo er;

    public PatientEntity create(PatientEntity ee){
        return er.save(ee);
    }

    public java.util.List<PatientEntity> getalldetails(){
        return er.findAll();
    
    }

    public PatientEntity getEmployeeById(int id){
        return er.findById(id).orElse(null);
    } 

    public boolean updateDetails(int id,PatientEntity employee)
        {
            if(this.getEmployeeById(id)==null)
            {
                return false;
            }
            try{
                er.save(employee);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }

        public boolean deleteEmployee(int id)
        {
            if(this.getEmployeeById(id) == null)
            {
                return false;
            }
            er.deleteById(id);
            return true;
        }

}