package com.mcb.creditfactory.util;

import com.mcb.creditfactory.model.Airplane;

public class AirplaneTestData {

    public static final Airplane AIRPLANE1 = new Airplane(1l,"newBrand", "Boing-777", (short) 2000, "BoingCo", 327, 66);

    public static Airplane getNew() {
        return new Airplane(null, "newBrand", "Boing-777", (short) 2000, "BoingCo", 327, 66);
    }
}
