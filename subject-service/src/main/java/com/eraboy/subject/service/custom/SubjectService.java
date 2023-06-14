package com.eraboy.subject.service.custom;

import com.eraboy.subject.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    void saveSubject(Subject subject);

    void deleteSubject(long id);

    void updateSubject(Subject subject);

    List<Subject> getAllSubjects();

    Optional<Subject> searchSubject(long id);
}
