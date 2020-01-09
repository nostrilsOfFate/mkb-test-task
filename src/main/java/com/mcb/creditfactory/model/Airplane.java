package com.mcb.creditfactory.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "AIRPLANE")
public class Airplane extends AbstractBaseEntity {

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "fuel_capacity")
    private Integer fuelCapacity;

    @Column(name = "seats")
    private Integer seats;

    public Airplane(Long id, String brand, String model, short year, String manufacturer, Integer fuelCapacity, Integer seats) {
        super(id, brand, model, year);
        this.manufacturer = manufacturer;
        this.fuelCapacity = fuelCapacity;
        this.seats = seats;
    }
}
