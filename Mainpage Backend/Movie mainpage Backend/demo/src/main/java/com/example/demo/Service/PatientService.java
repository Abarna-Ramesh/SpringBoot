package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Patient;
import com.example.demo.Repositary.PatientRepo;
@Service
public class PatientService {
    @Autowired
    PatientRepo mr;
    public Patient create (Patient mm)
    {
        return mr.save(mm);
    }
    public List<Patient> getAll()
    {
        return mr.findAll();
    }
    public Patient getMe(int id)
    {
        return mr.findById(id).orElse(null);
    }
    public boolean updateDetails(int id,Patient mm)
        {
            if(this.getMe(id)==null)
            {
                return false;
            }
            try{
                mr.save(mm);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
public boolean deleteMedicine(int id)
        {
            if(this.getMe(id) == null)
            {
                return false;
            }
            mr.deleteById(id);
            return true;
        }

}