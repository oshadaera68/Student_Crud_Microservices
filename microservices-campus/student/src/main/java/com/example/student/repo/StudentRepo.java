package com.example.student.repo;

import com.example.diploma.entity.Diploma;
import com.example.student.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Long> {
}
