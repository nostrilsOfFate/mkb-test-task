package com.mcb.creditfactory.util;

import com.mcb.creditfactory.model.Airplane;

public class AirplaneTestData {

    public static final Airplane AIRPLANE1 = new Airplane();
    public static final Airplane AIRPLANE2 = new Airplane();
    public static final Airplane AIRPLANE3 = new Airplane();

    public static Airplane getNew() {
        return new Airplane(null, "newBrand", "Boing-777", (short) 2000, "BoingCo", 327, 66);
    }
}
