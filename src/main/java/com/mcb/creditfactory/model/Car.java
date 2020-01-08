package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "CAR")
public class Car extends AbstractBaseEntity {

    @Column(name = "power")
    private Double power;

    public Car(Car car) {
        this(car.getId(), car.getBrand(), car.getModel(), car.getPower(), car.getAssessments());
    }

    public Car(Long id, String brand, String model, Double power, List<Assessment> assessments) {
        super(id, brand, model, assessments);
        this.power = power;
    }
}
