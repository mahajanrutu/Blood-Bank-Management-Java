package com.example.bloodbank;

public class Donor {
    private String name;
    private String bloodGroup;
    private String contact;

    public Donor(String name, String bloodGroup, String contact) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.contact = contact;
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getBloodGroup() { return bloodGroup; }
    public String getContact() { return contact; }

    public void setName(String name) { this.name = name; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public void setContact(String contact) { this.contact = contact; }
}
