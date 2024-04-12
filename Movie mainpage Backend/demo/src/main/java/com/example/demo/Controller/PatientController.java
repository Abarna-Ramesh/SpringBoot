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
import com.example.demo.Model.Patient;
import com.example.demo.Service.PatientService;
@RestController
public class PatientController {
    @Autowired
    PatientService ms;
    @PostMapping("/api/appointment")
    public ResponseEntity<Patient>addelements(@RequestBody Patient m)
    {
        Patient mm=ms.create(m);
        return new ResponseEntity<>(mm,HttpStatus.CREATED);
    }
    @GetMapping("/api/viewaAppointment")
    public ResponseEntity<List<Patient>> showinfo()
    {
        return new ResponseEntity<>(ms.getAll(),HttpStatus.OK);
    }
    @GetMapping("/api/viewaAppointment/{appointmentId}")
    public ResponseEntity<Patient> getById(@PathVariable Integer appointmentId)
    {
        Patient obj=ms.getMe(appointmentId);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/api/appointment/{appointmentId}")
    public ResponseEntity<Patient> putMethodName(@PathVariable("appointmentId") int id, @RequestBody Patient m) {
        if(ms.updateDetails(id,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/appointment/{appointmentId}")
    public ResponseEntity<Boolean> delete(@PathVariable("appointmentId") int id)
    {
        if(ms.deleteMedicine(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    //sorting
    @GetMapping("/order/sortBy/{field}")
    public List<Patient> sort(@PathVariable String field)
    {
        return ms.sort(field);
    }

    //pagination
    @GetMapping("/order/{offset}/{pagesize}")
    public List<Patient> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        return ms.page(pagesize, offset);
    }
    
    //sorting and pagination
    @GetMapping("/order/{offset}/{pagesize}/{field}")
    public List<Patient> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
       return ms.getsort(offset,pagesize,field);
    }
    
    @GetMapping("/gender")
    public List<Patient> getUsersWithGender() {
        return ms.getUsersWithGender();
    }
}

