package com.example.bloodbank;

import java.util.HashMap;
import java.util.Map;

public class BloodInventory {
    private Map<String, Integer> bloodStock;

    public BloodInventory() {
        bloodStock = new HashMap<>();
        bloodStock.put("A+", 0);
        bloodStock.put("A-", 0);
        bloodStock.put("B+", 0);
        bloodStock.put("B-", 0);
        bloodStock.put("O+", 0);
        bloodStock.put("O-", 0);
        bloodStock.put("AB+", 0);
        bloodStock.put("AB-", 0);
    }

    public void addBlood(String bloodGroup, int quantity) {
        bloodStock.put(bloodGroup, bloodStock.getOrDefault(bloodGroup, 0) + quantity);
    }

    public int getStock(String bloodGroup) {
        return bloodStock.getOrDefault(bloodGroup, 0);
    }

    public boolean reduceStock(String bloodGroup, int quantity) {
        int currentStock = bloodStock.getOrDefault(bloodGroup, 0);
        if (currentStock >= quantity) {
            bloodStock.put(bloodGroup, currentStock - quantity);
            return true;
        }
        return false;
    }

    public void displayStock() {
        System.out.println("Current Blood Stock:");
        for (Map.Entry<String, Integer> entry : bloodStock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " units");
        }
    }
}
