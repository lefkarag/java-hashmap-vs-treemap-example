package com.javacodegeeks;

public class MyHashMap {
    
    private final int INITIAL_SIZE = 10;
    
    private Entry[] buckets;
    
    public MyHashMap() {
        buckets = new Entry[INITIAL_SIZE];
    }
    
    public void put(String key, String value) {
        int index = hash(key);
        Entry entry = new Entry();
        entry.key = key;
        entry.value = value;
        
        if (buckets[index] == null) {
            buckets[index] = entry;
        } else {
            Entry curEntry = buckets[index];
            while (curEntry.next != null) {
                curEntry = curEntry.next;
            }
            curEntry.next = entry;
        }
    }
    
    public boolean remove(String key) {
        int index = hash(key);
        
        if (buckets[index] != null) {
            Entry curEntry = buckets[index];
            // found in first entry
            if (curEntry.key == key) {
                buckets[index] = curEntry.next;
                return true;
            }
            
            while (curEntry.next != null) {
                if (curEntry.next.key == key) {
                    curEntry.next = curEntry.next.next;
                    return true;
                }
            }
        }
        return false;
    }
    
    public String get(String key) {
        int index = hash(key);
        
        if (buckets[index] != null) {
            Entry curEntry = buckets[index];
            while (curEntry != null) {
                if (curEntry.key == key) {
                    return curEntry.value;
                }
                curEntry = curEntry.next;
            }
        }
        return null;
    }
    
    public boolean containsKey(String key) {
        int index = hash(key);
        
        if (buckets[index] != null) {
            Entry curEntry = buckets[index];
            while (curEntry != null) {
                if (curEntry.key == key) {
                    return true;
                }
                curEntry = curEntry.next;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                Entry curEntry = buckets[i];
                builder.append("[Index_" + i + "=");
                while (curEntry != null) {
                    builder.append(curEntry.key + ":" + curEntry.value + ",");
                    curEntry = curEntry.next;
                }
                // removes last comma
                builder.replace(builder.length()-1, builder.length(), "");
                builder.append("],");
            }
        }
        builder.replace(builder.length()-1, builder.length(), "");
        return builder.toString();
    }
    
    // Hash function
    private int hash(String key) {
        return key == null ? 0 : Math.abs(key.hashCode() % buckets.length);
    }
    
    class Entry {
        
        private String key;
        private String value;
        private Entry next;
    }
    
    public static void main(String[] args) {
        MyHashMap roleSalary = new MyHashMap();
        roleSalary.put("Senior", "50000");
        roleSalary.put("Junior", "30000");
        roleSalary.put("Architect", "80000");
        roleSalary.put("CTO", "100000");
        
        System.out.println("Initial map: " + roleSalary);
        System.out.println("The salary of the CTO is: " + (roleSalary.containsKey("CTO") ? roleSalary.get("CTO") : "Uknown"));
        System.out.println("The salary of the CEO is: " + (roleSalary.containsKey("CEO") ? roleSalary.get("CEO") : "Uknown"));
        System.out.println("Removing the salary of Junior: " + roleSalary.remove("Junior"));
        System.out.println("Removing the salary of the CEO: " + roleSalary.remove("CEO"));
        System.out.println("Map after removals: " + roleSalary);
    }
}