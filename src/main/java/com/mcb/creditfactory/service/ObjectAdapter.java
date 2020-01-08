package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class ObjectAdapter  implements CollateralObject {

    private Collateral object;

    @Override
    public BigDecimal getValue() {
//        return object.();
        return null;
    }

    @Override
    public Short getYear() {
//        return car.getAssessments().stream()
//                .sorted(// по дате);
//                .findFirst()
//                .orElse(null).getYear();
                return null;
    }

    @Override
    public LocalDate getDate() {
        // Для автомобилей дата оценки не используется, поэтому всегда берем текущую
        return LocalDate.now();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }
}
