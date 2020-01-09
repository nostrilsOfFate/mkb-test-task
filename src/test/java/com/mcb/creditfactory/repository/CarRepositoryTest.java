package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.Assessment;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.util.CarTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Sql(scripts = "classpath:populateDB.sql")
@SpringBootTest
class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Test
    void create() {
        Car car = new Car(null, "brand", "model", (short) 2020, 1.2);
        Assessment assessment = new Assessment(null, BigDecimal.valueOf(1000000), LocalDate.now());
        Assessment asSaved = assessmentRepository.save(assessment);
        assertNotNull(asSaved);
        car.setAssessments(Collections.singletonList(assessment));
        Car actual = repository.save(car);
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertNotNull(actual.getAssessments());
    }

    @Test
    void getAll() {
        List<Car> cars = repository.findAll();
        assertNotNull(cars);
        assertTrue(cars.size() > 0);
    }

    @Test
    void get() {
        Car car = repository.findById(1L).orElse(null);
        assertNotNull(car);
    }

    @Test
    void delete() {
        repository.deleteById(1L);
        assertEquals(3, repository.findAll().size());
    }

    @Test
    void update() {
        Car expected = repository.findById(1L).orElse(null);
        assertNotNull(expected);
        expected.setBrand("SUPER Brand");
        Car savedCar = repository.save(expected);
        assertNotNull(savedCar);
        Car actual = repository.findById(1L).orElse(null);
        assertNotNull(actual);
        assertEquals(expected.getBrand(), actual.getBrand());
    }
}