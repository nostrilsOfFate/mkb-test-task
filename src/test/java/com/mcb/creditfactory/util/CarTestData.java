package com.mcb.creditfactory.util;

import com.mcb.creditfactory.model.Car;

import java.util.Collections;

public class CarTestData {
    public static final Car CAR1 = new Car(1L, "brand1CAR", "model1CAR", 1.1, Collections.emptyList());
    public static final Car CAR2 = new Car();
    public static final Car CAR3 = new Car();


    public static Car getNew() {
        return new Car();
    }

    public static Car getUpdated() {
        Car updated = new Car(CAR1);
//        updated.setNumberOfRepeat(15);
        return updated;
    }
}
