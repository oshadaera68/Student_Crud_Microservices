package com.eraboy.diploma.service.custom.impl;

import com.eraboy.diploma.entity.Diploma;
import com.eraboy.diploma.repo.DiplomaRepo;
import com.eraboy.diploma.service.custom.DiplomaService;
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

    @Override
    public void saveDiploma(Diploma d) {
        diplomaRepo.save(d);
    }

    @Override
    public void deleteDiploma(long id) {
        if (diplomaRepo.existsById(id)) {
            diplomaRepo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the diploma id..");
        }
    }

    @Override
    public void updateDiploma(Diploma d) {
        if (diplomaRepo.existsById(d.getId())) {
            diplomaRepo.save(d);
        } else {
            throw new RuntimeException("No such diploma to update, Please check the id..");
        }
    }

    @Override
    public List<Diploma> getAllDiplomas() {
        return (List<Diploma>) diplomaRepo.findAll();
    }

    @Override
    public Optional<Diploma> searchDiploma(long id) {
        return diplomaRepo.findById(id);
    }
}
