package com.jnesis.jap.peartopear.utils;

import java.util.Map;
import java.util.TreeMap;

public class Benchmark {
    private long startTime;
    private long stopTime;
    private Map<Long, String> timesList = new TreeMap<>();

    public Benchmark() {
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
    }

    public void bookmark(String value) {
        timesList.put(startTime + stopTime, value);
    }

    public String toString() {
        for(Map.Entry<Long, String> entry : timesList.entrySet()) {
            return String.format(entry.getValue() + "  " + Long.toString(entry.getKey()));
        }
        return super.toString();
    }
}
