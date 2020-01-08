package com.mcb.creditfactory.util;

import com.mcb.creditfactory.model.Airplane;

public class AirplaneTestData {

    public static final Airplane AIRPLANE1 = new Airplane();
    public static final Airplane AIRPLANE2 = new Airplane();
    public static final Airplane AIRPLANE3 = new Airplane();

    public static Airplane getNew() {
        return new Airplane();
    }

    public static Airplane getUpdated() {
        Airplane updated = new Airplane(AIRPLANE1);
//        updated.setNumberOfRepeat(15);
        return updated;
    }


}
