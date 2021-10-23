package tda.springframework.studentapiproject.service;

import org.springframework.stereotype.Service;
import tda.springframework.studentapiproject.model.Student;
import tda.springframework.studentapiproject.repository.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    public List<Student> getAll()
    {
        return studentRepository.findAll();
    }
    public Optional<Student> getById(Long id)
    {
        return studentRepository.findById(id);
    }
    public void add(Student student)
    {
        studentRepository.save(student);
    }
    public void update(Long id, Student student)
    {
        student.setId(id);
        studentRepository.save(student);
    }
    public void delete(Long id)
    {
        studentRepository.deleteById(id);
    }
    public List<Student> getByName(String name)
    {
        return studentRepository.findByName(name);
    }
    public List<Student> getByNameAndEmail(String name , String email)
    {
        return studentRepository.findByNameAndEmail(name,email);
    }
}
