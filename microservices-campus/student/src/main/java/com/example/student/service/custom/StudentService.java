package com.example.student.service.custom;

import com.example.diploma.entity.Diploma;
import com.example.student.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void saveStudent(Student s);

    void deleteStudent(long id);

    void updateStudent(Student s);

    List<Student> getAllStudents();

    Optional<Student> searchStudent(long id);
}
