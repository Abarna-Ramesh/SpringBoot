package com.example.demo.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Doctor;
// import com.example.demo.Model.Patient;
import com.example.demo.Service.DoctorService;
// import com.example.demo.Service.PatientService;
@RestController
public class DoctorController {
    @Autowired
    DoctorService ms;
    @PostMapping("/api/post")
    public ResponseEntity<Doctor>addelements(@RequestBody Doctor m)
    {
        Doctor mm=ms.create(m);
        return new ResponseEntity<>(mm,HttpStatus.CREATED);
    }
    @GetMapping("/api/get")
    public ResponseEntity<List<Doctor>> showinfo()
    {
        return new ResponseEntity<>(ms.getAll(),HttpStatus.OK);
    }
    @GetMapping("/api/{doctorId}")
    public ResponseEntity<Doctor> getById(@PathVariable Integer doctorId)
    {
        Doctor obj=ms.getMe(doctorId);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/api/{doctorId}")
    public ResponseEntity<Doctor> putMethodName(@PathVariable("doctorId") int id, @RequestBody Doctor m) {
        if(ms.updateDetails(id,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/{doctorId}")
    public ResponseEntity<Boolean> delete(@PathVariable("appointmentId") int id)
    {
        if(ms.deleteMedicine(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    
}

