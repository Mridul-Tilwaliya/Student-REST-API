package tda.springframework.studentapiproject.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tda.springframework.studentapiproject.model.Student;
import tda.springframework.studentapiproject.service.StudentService;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/")
public class StudentController 
{    
    private StudentService studentService;
    Optional<Student> student;
    String response;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllStudents()
    {      
        if( studentService.getAll().isEmpty() )
        {
            return status(HttpStatus.OK).body("No records found , Database is Empty");           
        }
        else
        {   
            return status(HttpStatus.OK).body(studentService.getAll());            
        }          
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id)
    {
        student = studentService.getById(id);        
        if( student.isPresent() )
        {
            return status(HttpStatus.OK).body(student.get());            
        }
        else
        {   
            return status(HttpStatus.OK).body("Record of " + id + " does not exists");
        }        
    }
    
    @GetMapping("/byname/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name)
    {       
        if( studentService.getByName(name).isEmpty() )
        {
            return status(HttpStatus.OK).body("Record  of " + name + " does not exists");                        
        }
        else
        {   
            return status(HttpStatus.OK).body(studentService.getByName(name));
        }   
    }

    @GetMapping("/byemail/{name}/{email}")
    public ResponseEntity<?> getByNameAndEmail(@PathVariable("name") String name,@PathVariable("email") String email)
    {
        return status(HttpStatus.OK).body(studentService.getByNameAndEmail(name,email));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Student student)
    {
        studentService.add(student);
        return status(HttpStatus.CREATED).body("Student added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Student student)
    {
        studentService.update(id, student);
        return status(HttpStatus.OK).body("Student updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id)
    {
        student = studentService.getById(id);        
        if( student.isPresent() )
        {
            studentService.delete(id);
            response = "Student deleted successfully";            
        }
        else
        {   
            response = "Record does not exists";
        }
        return status(HttpStatus.OK).body(response);
    }
}