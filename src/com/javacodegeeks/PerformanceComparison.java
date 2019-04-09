package com.javacodegeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PerformanceComparison {
    
    static final int COUNT = 1000000;
 
    public static void main(String[] args) {
        System.out.println("*** HashMap Performance ***");
        performanceRun(new HashMap(COUNT));
 
        System.out.println("\n*** TreeMap Performance ***");
        performanceRun(new TreeMap());
    }
 
    static void performanceRun(Map<Integer, Integer> map) {
        // warm up
        for (int i = COUNT; i >= 0; i--) {
            map.put(i, i * 10);
        }
        
        // put
        long now = System.currentTimeMillis();
        for (int i = COUNT; i >= 0; i--) {
            map.put(i, i * 10);
        }
        System.out.println("Put took: " + (System.currentTimeMillis() - now) + " ms");
 
        // get
        now = System.currentTimeMillis();
        for (int i = COUNT; i >= 0; i--) {
            map.get(i);
        }
        System.out.println("Get took: " + (System.currentTimeMillis() - now) + " ms");

        // containsKey
        now = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            map.containsKey(i);
        }
        System.out.println("Contains took: " + (System.currentTimeMillis() - now) + " ms");
 
        // remove
        now = System.currentTimeMillis();
        for (int i = COUNT; i >= 0; i--) {
            map.remove(i);
        }
        System.out.println("Remove took: " + (System.currentTimeMillis() - now) + " ms");
    }
}