package com.mcb.creditfactory.util;

import com.mcb.creditfactory.model.Car;

public class CarTestData {
    public static final Car CAR1 = new Car(1L, "brand1CAR", "model1CAR", (short) 2001, 1.1);

    public static Car getNew() {
        return new Car(null, "brandNewCAR", "modelNewCAR", (short) 2000, 1.0);
    }
}
