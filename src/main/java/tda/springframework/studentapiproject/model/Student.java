package tda.springframework.studentapiproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Integer roll;
    private String grade;
    private String school;

    public Student() 
    {
    }

    public Student(Long id, String name, String email, String phone, Integer roll, String grade, String school) 
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.roll = roll;
        this.grade = grade;
        this.school = school;
    }

    public Student(String name, String email, String phone, Integer roll, String grade, String school) 
    {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.roll = roll;
        this.grade = grade;
        this.school = school;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public Integer getRoll()
    {
        return roll;
    }

    public void setRoll(Integer roll) 
    {
        this.roll = roll;
    }

    public String getGrade() 
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getSchool()
    {
        return school;
    }

    public void setSchool(String school) 
    {
        this.school = school;
    }


    @Override
    public String toString() 
    {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", roll=" + roll +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
