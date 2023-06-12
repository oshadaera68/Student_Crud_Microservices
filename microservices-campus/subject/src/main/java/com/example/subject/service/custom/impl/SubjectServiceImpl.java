package com.example.subject.service.custom.impl;

import com.example.subject.repo.SubjectRepo;
import com.example.subject.service.custom.SubjectService;
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
    public void saveSubject(com.example.subject.entity.Subject subject) {
        subjectRepo.save(subject);
    }

    @Override
    public void updateSubject(com.example.subject.entity.Subject subject) {
        if (subjectRepo.existsById(subject.getSubCode())) {
            subjectRepo.save(subject);
        } else {
            throw new RuntimeException("No such subject to update, Please check the id..");
        }
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
    public List<com.example.subject.entity.Subject> getAllSubjects() {
        return (List<com.example.subject.entity.Subject>) subjectRepo.findAll();
    }

    @Override
    public Optional<com.example.subject.entity.Subject> searchSubject(long id) {
        return subjectRepo.findById(id);
    }

}