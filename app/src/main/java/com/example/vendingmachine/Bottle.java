package com.example.vendingmachine;

public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    private double bottle_size;
    private double bottle_price;
    private int quantity;
    public Bottle(){
        name = "Pepsi Max";
        manufacturer = "Pepsi";
        total_energy = 0.3;
        bottle_size = 0.5;
        bottle_price = 1.8;
        quantity = 1;
    }
    public Bottle(String n, String manuf, double totE, double price, double size, int qty){
        name = n;
        manufacturer = manuf;
        total_energy = totE;
        bottle_price = price;
        bottle_size = size;
        quantity = qty;
    }
    public String getName(){
        return name;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public double getEnergy(){
        return total_energy;
    }
    public double getBottle_price(){
        return bottle_price;
    }

    public double getBottle_size() {
        return bottle_size;
    }
    public int getQuantity(){
        return quantity;
    }
    public void decrementQuantity(){
        if(quantity > 0){
            quantity -= 1;
        }
    }
}

