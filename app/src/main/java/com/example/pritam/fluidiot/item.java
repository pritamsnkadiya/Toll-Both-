package com.example.pritam.fluidiot;

public class item {

    private String tName;
    private int tPrice;
    private boolean checked;

    public item() {
    }

    public item(String tName, int tPrice) {
        this.tName = tName;
        this.tPrice = tPrice;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int gettPrice() {
        return tPrice;
    }

    public void settPrice(int tPrice) {
        this.tPrice = tPrice;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
