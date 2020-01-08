package com.mcb.creditfactory.service.assessment;

import com.mcb.creditfactory.model.Assessment;

import java.util.List;

public interface AssessmentService {
    Assessment save(Assessment assessment);

    Assessment getById(Long id);

    List<Assessment> getAll();

    void deleteById(Long id);
}
