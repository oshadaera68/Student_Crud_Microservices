package com.eraboy.subject.repo;

import com.eraboy.subject.entity.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepo extends CrudRepository<Subject, Long> {
}
