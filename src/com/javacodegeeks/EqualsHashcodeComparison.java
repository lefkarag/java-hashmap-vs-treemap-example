package com.javacodegeeks;

import java.util.HashMap;
import java.util.Map;

public class EqualsHashcodeComparison {

    static final int COUNT = 10000;

    public static void main(String[] args) {
        Map<GoodHashcode, Integer> map1 = new HashMap<>();
        Map<BadHashcode, Integer> map2 = new HashMap<>();

        System.out.println("*** GoodHashcode Performance ***");
        long now = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            map1.put(new GoodHashcode(i), i);
        }
        System.out.println("Put took: " + (System.currentTimeMillis() - now));

        now = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            map1.get(new GoodHashcode(i));
        }
        System.out.println("Get took: " + (System.currentTimeMillis() - now));

        System.out.println("\n*** GoodHashcode Performance ***");
        now = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            map2.put(new BadHashcode(i), i);
        }
        System.out.println("Put took: " + (System.currentTimeMillis() - now));

        now = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            map2.get(new BadHashcode(i));
        }
        System.out.println("Get took: " + (System.currentTimeMillis() - now));
    }

}

class GoodHashcode {

    int id;

    GoodHashcode(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GoodHashcode other = (GoodHashcode) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

}

class BadHashcode {

    int id;

    BadHashcode(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return 10; // DON'T DO THAT !!!
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BadHashcode other = (BadHashcode) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }
}