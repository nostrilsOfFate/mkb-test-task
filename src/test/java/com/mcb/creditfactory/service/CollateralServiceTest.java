package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.repository.AirplaneRepository;
import com.mcb.creditfactory.repository.AssessmentRepository;
import com.mcb.creditfactory.repository.CarRepository;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import com.mcb.creditfactory.service.assessment.AssessmentService;
import com.mcb.creditfactory.service.car.CarService;
import com.mcb.creditfactory.util.AirplaneTestData;
import com.mcb.creditfactory.util.CarTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:populateDB.sql")
class CollateralServiceTest {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarService carService;
    @Autowired
    private AirplaneRepository airplaneRepository;
    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private AssessmentRepository assessmentRepository;
    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private CollateralService collateralService;

    @Test
    void saveNewCarCollateral() {
        CarDto carDto = new CarDto(null, "brand", "model", 1.0, (short) 2001, BigDecimal.valueOf(1000000));
        Long l = collateralService.saveCollateral(carDto);
        assertNotNull(l);
        assertEquals(5, (long) l);
    }

    @Test
    void saveOldCarCollateral() {
        Car car = carRepository.findById(1L).orElse(null);
        assertNotNull(car);
        int expected = car.getAssessments().size();
        CarDto carDto = carService.toDTO(car);
        carDto.setValue(BigDecimal.valueOf(2000000));
        collateralService.saveCollateral(carDto);
        Car carNew = carRepository.findById(1L).orElse(null);
        assertNotNull(carNew);
        int actual = carNew.getAssessments().size();
        assertEquals(expected + 1, actual);
    }

    @Test
    void saveNewAirplaneCollateral() {
        AirplaneDto airplaneDto = new AirplaneDto(null, "brand", "model", "manuf", 12, 12, (short) 2000, BigDecimal.valueOf(240000000));
        Long l = collateralService.saveCollateral(airplaneDto);
        assertNotNull(l);
        assertEquals(5, (long) l);
    }

    @Test
    void saveOldAirplaneCollateral() {
        Airplane airplane = airplaneRepository.findById(1L).orElse(null);
        assertNotNull(airplane);
        int expected = airplane.getAssessments().size();
        AirplaneDto airplaneDto = airplaneService.toDTO(airplane);
        airplaneDto.setValue(BigDecimal.valueOf(250000000));
        collateralService.saveCollateral(airplaneDto);
        Airplane airplaneNew = airplaneRepository.findById(1L).orElse(null);
        assertNotNull(airplaneNew);
        int actual = airplaneNew.getAssessments().size();
        assertEquals(expected + 1, actual);
    }

    @Test
    void getNewCarInfo() {
        CarDto carDto = new CarDto(1L, "brand1CAR", "model1CAR", 1.1, (short) 2010, BigDecimal.valueOf(44444444));
        assertNotNull(carDto);
        assertEquals(carDto, collateralService.getInfo(carDto));
    }

    @Test
    void getOldCarInfo() {
        Car car = carRepository.findById(1L).orElse(null);
        assertNotNull(car);
        CarDto carDto = carService.toDTO(car);
        assertEquals(carDto, collateralService.getInfo(carDto));
    }

    @Test
    void getNewAirplaneInfo() {
        AirplaneDto airplaneDto = new AirplaneDto(1L, "brand1AIRPLANE", "model1AIRPLANE", "manuf1", 1, 1, (short) 2010, BigDecimal.valueOf(22222222));
        assertNotNull(airplaneDto);
        assertEquals(collateralService.getInfo(airplaneDto), airplaneDto);
    }

    @Test
    void getOldAirplaneInfo() {
        Airplane airplane = airplaneRepository.findById(1L).orElse(null);
        assertNotNull(airplane);
        AirplaneDto airplaneDto = airplaneService.toDTO(airplane);
        assertNotNull(airplaneDto);
        assertEquals(collateralService.getInfo(airplaneDto), airplaneDto);
    }
}