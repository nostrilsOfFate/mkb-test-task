package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.Assessment;
import com.mcb.creditfactory.util.AirplaneTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Sql(scripts = "classpath:populateDB.sql")
@SpringBootTest
class AirplaneRepositoryTest {

    @Autowired
    private AirplaneRepository repository;

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Test
    void create() {
        Airplane airplane = AirplaneTestData.getNew();
        Assessment assessment = new Assessment(null, BigDecimal.valueOf(240000000), LocalDate.now());
        Assessment asSaved = assessmentRepository.save(assessment);
        assertNotNull(asSaved);
        airplane.setAssessments(Collections.singletonList(assessment));
        Airplane actual = repository.save(airplane);
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertNotNull(actual.getAssessments());
    }
    @Test
    void getAll() {
        List<Airplane> airplanes = repository.findAll();
        assertNotNull(airplanes);
        assertTrue(airplanes.size() > 0);
    }

    @Test
    void get() {
        Airplane airplane = repository.findById(1L).orElse(null);
        assertNotNull(airplane);
    }

    @Test
    void delete() {
        repository.deleteById(1L);
        assertEquals(3, repository.findAll().size());
    }

    @Test
    void update() {
        Airplane expected = repository.findById(1L).orElse(null);
        assertNotNull(expected);
        expected.setBrand("SUPER Brand");
        Airplane savedAirplane = repository.save(expected);
        assertNotNull(savedAirplane);
        Airplane actual = repository.findById(1L).orElse(null);
        assertNotNull(actual);
        assertEquals(expected.getBrand(), actual.getBrand());
    }
}