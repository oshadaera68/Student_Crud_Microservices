package com.example.student.service.custom.impl;

import com.example.diploma.entity.Diploma;
import com.example.diploma.repo.DiplomaRepo;
import com.example.diploma.service.custom.DiplomaService;
import com.example.student.entity.Student;
import com.example.student.repo.StudentRepo;
import com.example.student.service.custom.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudent(long id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the student id..");
        }
    }

    public void updateStudent(Student student) {
        if (studentRepo.existsById(student.getId())) {
            studentRepo.save(student);
        } else {
            throw new RuntimeException("No such student to update, Please check the id..");
        }
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepo.findAll();
    }

    public Optional<Student> searchStudent(long id) {
        return studentRepo.findById(id);
    }
}