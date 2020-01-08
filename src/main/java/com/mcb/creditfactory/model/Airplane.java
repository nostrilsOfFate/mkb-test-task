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
@Table(name = "AIRPLANE")
public class Airplane extends AbstractBaseEntity {

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "fuelCapacity")
    private Integer fuelCapacity;

    @Column(name = "seats")
    private Integer seats;


    public Airplane(Airplane airplane) {
        this(airplane.getId(), airplane.getBrand(), airplane.getModel(), airplane.getManufacturer(), airplane.getFuelCapacity(), airplane.getSeats(), airplane.getAssessments());
    }

    public Airplane(Long id, String brand, String model, String manufacturer, Integer fuelCapacity, Integer seats, List<Assessment> assessments) {
        super(id, brand, model, assessments);
        this.manufacturer = manufacturer;
        this.fuelCapacity = fuelCapacity;
        this.seats = seats;
    }
}
