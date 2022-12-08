package org.hx.java.adt;


import static org.hx.java.adt.Month.JANUARY;
import static org.hx.java.adt.Month.MARCH;

enum Month {
    /**
     *
     */
    JANUARY, FEBRUARY, MARCH, DECEMBER
};

public class EnumerationsClient {

    public static void main(String[] args) {
        Month january = JANUARY;
        System.out.println(january);
        System.out.println(january.ordinal());

        String juan = "JANUARY";

        if (juan.equals(JANUARY)) {
            System.out.println("euqals");
        }
        System.out.println(JANUARY.compareTo(MARCH));
    }
}
