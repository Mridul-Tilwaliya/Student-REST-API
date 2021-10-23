package tda.springframework.studentapiproject.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tda.springframework.studentapiproject.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>
{
    public List<Student> findByName(String name);
    public List<Student> findByNameAndEmail(String name, String email);    
}