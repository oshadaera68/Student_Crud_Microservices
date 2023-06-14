package com.eraboy.subject.service.custom.impl;

import com.eraboy.subject.entity.Subject;
import com.eraboy.subject.repo.SubjectRepo;
import com.eraboy.subject.service.custom.SubjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public void saveSubject(Subject subject) {
        subjectRepo.save(subject);
    }

    @Override
    public void deleteSubject(long id) {
        if (subjectRepo.existsById(id)) {
            subjectRepo.deleteById(id);
        } else {
            throw new RuntimeException("Try again");
        }
    }

    @Override
    public void updateSubject(Subject subject) {
        if (subjectRepo.existsById(subject.getSubCode())) {
            subjectRepo.save(subject);
        } else {
            throw new RuntimeException("No such subject to update, Please check the id..");
        }
    }

    @Override
    public List<Subject> getAllSubjects() {
        return (List<Subject>) subjectRepo.findAll();
    }

    @Override
    public Optional<Subject> searchSubject(long id) {
        return subjectRepo.findById(id);
    }
}
