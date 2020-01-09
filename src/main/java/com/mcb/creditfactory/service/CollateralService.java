package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.model.AbstractBaseEntity;
import com.mcb.creditfactory.model.Assessment;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import com.mcb.creditfactory.service.assessment.AssessmentService;
import com.mcb.creditfactory.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

// TODO: reimplement this
@Service
@Transactional
public class CollateralService {
    @Autowired
    private CarService carService;
    @Autowired
    private AirplaneService airplaneService;
    @Autowired
    private AssessmentService assessmentService;



    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {
        Assessment assessment;
        if (object instanceof CarDto) {
            CarDto car = (CarDto) object;
            boolean approved = carService.approve(car);
            if (!approved) {
                return null;
            }
            assessment = assessmentService.save(car.getValue());
            return Optional.of(car)
                    .map(carService::fromDto)
                    .map(car1 -> {
                        Long id = car1.getId();
                        List<Assessment> list = new ArrayList<>();
                        if (id != null) {
                            list = carService.load(id).get().getAssessments();
                        }
                        fillAssesments(list, assessment);
                        car1.setAssessments(list);
                        return carService.save(car1);
                    })
                    .map(carService::getId)
                    .orElse(null);
        } else if (object instanceof AirplaneDto) {
            AirplaneDto airplane = (AirplaneDto) object;
            boolean approved = airplaneService.approve(airplane);
            if (!approved) {
                return null;
            }
            assessment = assessmentService.save(airplane.getValue());
            return Optional.of(airplane)
                    .map(airplaneService::fromDto)
                    .map(airplane1 -> {
                        Long id = airplane1.getId();
                        List<Assessment> list = new ArrayList<>();
                        if (id != null) {
                            list = airplaneService.load(id).get().getAssessments();
                        }
                        fillAssesments(list, assessment);
                        airplane1.setAssessments(list);
                        return airplaneService.save(airplane1);
                    })
                    .map(airplaneService::getId)
                    .orElse(null);
        } else throw new IllegalArgumentException();

    }

    public Collateral getInfo(Collateral object) {
        if (object instanceof CarDto) {
            return Optional.of((CarDto) object)
                    .flatMap(carDto -> carService.load(carDto.getId()))
                    .map(carService::toDTO)
                    .orElse(null);
        } else if (object instanceof AirplaneDto) {
            return Optional.of((AirplaneDto) object)
                    .flatMap(airplaneDto -> airplaneService.load(airplaneDto.getId()))
                    .map(airplaneService::toDTO)
                    .orElse(null);
        } else throw new IllegalArgumentException();
    }

    private void fillAssesments(List<Assessment> previousAssessments, Assessment newAssessment) {
        previousAssessments.add(newAssessment);
    }
}
