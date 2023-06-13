package com.eraboy.diploma.service.custom;

import com.eraboy.diploma.entity.Diploma;

import java.util.List;
import java.util.Optional;

public interface DiplomaService {
    void saveDiploma(Diploma d);

    void deleteDiploma(long id);

    void updateDiploma(Diploma d);

    List<Diploma> getAllDiplomas();

    Optional<Diploma> searchDiploma(long id);
}
