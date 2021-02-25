package com.example.vendingmachine;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;

import java.util.*;

class BottleDispenser {
    private static BottleDispenser bottleDispenser = null;
    private int bottles;
    // The array for the Bottle-objects
    private ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();
    private double money;

    private BottleDispenser(){
        money = 0.0;
        bottle_array.add(new Bottle("OISPA!", "OISPA", 0.5, 2.2, 0.33, 2));
        bottle_array.add(new Bottle("RÖI-KOLA", "RÖIKOLA", 0.5, 2.0, 0.33, 2));
        bottle_array.add(new Bottle("KALJALA", "KALJALA", 1.5, 2.5, 0.5, 2));
        bottle_array.add(new Bottle("HAKUNILA SPRITZ", "HAKUNILA", 2.5, 2.75, 1.5, 2));
    }

    public static BottleDispenser getInstance() {
        if(bottleDispenser == null)
            bottleDispenser = new BottleDispenser();
        return bottleDispenser;
    }

    public void addMoney(double amount) {
        money += amount;
        System.out.println("Klink! Added more money!" + amount);
    }

    public String buyBottle(int input) {
        int index = input - 1;
        Bottle bottle = bottle_array.get(index);

        if(bottle.getQuantity() <= 0){
            return "There are no bottles to sell";
        }
        if(money <= 0 || money < bottle.getBottle_price()){
            return "Add at least " + String.format("%.2f", bottle.getBottle_price() - money) + " to buy.";
        }
        else {
            money -= bottle.getBottle_price();
            bottle.decrementQuantity();
            return "KACHUNK! " + bottle.getName() +  " came out of the dispenser!";
        }


    }

    public double getMoneyAmount(){
        return money;
    }

    @SuppressLint("DefaultLocale")
    public double returnMoney() {
        double moneyLeft = money;
        money = 0;
        return moneyLeft;

    }
}
