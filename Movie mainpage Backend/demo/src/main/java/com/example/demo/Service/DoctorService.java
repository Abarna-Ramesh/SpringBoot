package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Doctor;
// import com.example.demo.Model.Patient;
import com.example.demo.Repositary.DoctorRepo;
// import com.example.demo.Repositary.PatientRepo;
@Service
public class DoctorService {
    @Autowired
   DoctorRepo mr;
    public Doctor create (Doctor mm)
    {
        return mr.save(mm);
    }
    public List<Doctor> getAll()
    {
        return mr.findAll();
    }
    public Doctor getMe(int id)
    {
        return mr.findById(id).orElse(null);
    }
    public boolean updateDetails(int id,Doctor mm)
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
        //sorting by field
    public List<Doctor> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return mr.findAll(sort);
    }

    //pagination
    public List<Doctor> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return mr.findAll(page).getContent();
    }

    //sorting and pagination
    public List<Doctor> getsort(int pageNumber,int pageSize,String field)
    {          return mr.findAll(PageRequest.of(pageNumber, pageSize)
          .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
    

}