package com.example.diploma.service.custom.impl;

import com.example.diploma.entity.Diploma;
import com.example.diploma.repo.DiplomaRepo;
import com.example.diploma.service.custom.DiplomaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiplomaServiceImpl implements DiplomaService {

    @Autowired
    private DiplomaRepo diplomaRepo;


    public void saveDiploma(Diploma d) {
        diplomaRepo.save(d);
    }

    public void deleteDiploma(long id) {
        if (diplomaRepo.existsById(id)) {
            diplomaRepo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the diploma id..");
        }
    }

    public void updateDiploma(Diploma d) {
        if (diplomaRepo.existsById(d.getId())) {
            diplomaRepo.save(d);
        } else {
            throw new RuntimeException("No such diploma to update, Please check the id..");
        }
    }

    public List<Diploma> getAllDiplomas() {
        return (List<Diploma>) diplomaRepo.findAll();
    }

    public Optional<Diploma> searchDiploma(long id) {
        return diplomaRepo.findById(id);
    }
}
