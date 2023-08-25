package com.ElectricityBillSystem;

public class Consumer {
	private int c_id;
    private String c_name;
    private String c_age;
    private String c_type;

    // Constructors
    public Consumer(int c_id, String c_name, String c_age, String c_type) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_age = c_age;
        this.c_type = c_type;
    }

    public Consumer() {
        // Default constructor
    }

    // Getters and Setters
    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_age() {
        return c_age;
    }

    public void setC_age(String c_age) {
        this.c_age = c_age;
    }

    public String getC_type() {
        return c_type;
    }

    public void setC_type(String c_type) {
        this.c_type = c_type;
    }
    // toString method to represent the object as a string
    @Override
    public String toString() {
        return "Consumer [c_id=" + c_id + ", c_name=" + c_name + ", c_age=" + c_age + ", c_type=" + c_type + "]";
    }
}
