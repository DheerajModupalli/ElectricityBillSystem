package com.ElectricityBillSystem;

public class Bill {
	private int b_id;
    private int c_id;
    private float b_units;
    private String b_type;
    private float b_amt;

    // Constructors
    public Bill(int b_id, int c_id, float b_units, String b_type, float b_amt) {
        this.b_id = b_id;
        this.c_id = c_id;
        this.b_units = b_units;
        this.b_type = b_type;
        this.b_amt = b_amt;
    }

    public Bill() {
        // Default constructor
    }

    // Getters and Setters
    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public float getB_units() {
        return b_units;
    }

    public void setB_units(float b_units) {
        this.b_units = b_units;
    }

    public String getB_type() {
        return b_type;
    }

    public void setB_type(String b_type) {
        this.b_type = b_type;
    }

    public float getB_amt() {
        return b_amt;
    }

    public void setB_amt(float b_amt) {
        this.b_amt = b_amt;
    }

    // toString method to represent the object as a string
    @Override
    public String toString() {
        return "Bill [b_id=" + b_id + ", c_id=" + c_id + ", b_units=" + b_units + ", b_type=" + b_type + ", b_amt=" + b_amt + "]";
    }
}
