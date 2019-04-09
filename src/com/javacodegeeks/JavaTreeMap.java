package com.javacodegeeks;

import java.util.Comparator;
import java.util.TreeMap;

public class JavaTreeMap {
    
    static Comparator<Role> comparator = new Comparator<Role>() {

        @Override
        public int compare(Role r1, Role r2) {
            return r1.hierarchy - r2.hierarchy;
        }
    };
    
    public static void main(String[] args) {
        TreeMap<Role, Integer> roleSalary = new TreeMap<>(comparator);
        roleSalary.put(new Role(3, "Senior"), 50000);
        roleSalary.put(new Role(4, "Junior"), 30000);
        roleSalary.put(new Role(2, "Architect"), 80000);
        roleSalary.put(new Role(1, "CTO"), 100000);
        
        System.out.println(roleSalary);
    }
}

class Role {
    int hierarchy;
    String name;

    public Role(int hierarchy, String name) {
        this.hierarchy = hierarchy;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "[" + hierarchy + ":" + name + "]";
    }
}