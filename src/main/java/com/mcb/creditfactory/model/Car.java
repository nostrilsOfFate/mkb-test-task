package com.mcb.creditfactory.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "CAR")
@ToString(callSuper = true)
public class Car extends AbstractBaseEntity {

    @Column(name = "power")
    private Double power;

    public Car(Long id, String brand, String model, short year, Double power) {
        super(id, brand, model, year);
        this.power = power;
    }
}
