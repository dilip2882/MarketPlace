package com.dilip.marketplace.ui;

public class AddressesModel {
    private String fullName;
    private String address;
    private String pincode;
    private boolean selected;

    public AddressesModel(String fullName, String address, String pincode, boolean selected) {
        this.fullName = fullName;
        this.address = address;
        this.pincode = pincode;
        this.selected = selected;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        selected = selected;
    }
}
