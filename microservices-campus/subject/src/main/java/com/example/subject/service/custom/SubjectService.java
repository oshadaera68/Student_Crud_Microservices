package com.example.subject.service.custom;
import javax.security.auth.Subject;
import java.util.List;
import java.util.Optional;

public interface SubjectService {
    void saveSubject(com.example.subject.entity.Subject subject);

    void deleteSubject(long id);

    void updateSubject(com.example.subject.entity.Subject subject);

    List<com.example.subject.entity.Subject> getAllSubjects();

    Optional<com.example.subject.entity.Subject> searchSubject(long id);
}
