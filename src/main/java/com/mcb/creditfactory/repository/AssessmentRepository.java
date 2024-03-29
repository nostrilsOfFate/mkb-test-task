package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.Assessment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends CrudRepository<Assessment, Long> {
    List<Assessment> findAll();
}
