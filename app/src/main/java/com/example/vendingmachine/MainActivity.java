package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Dialog.DialogListener {
    Context context = null;
    TextView balanceField;
    TextView outputField;
    Button returnButton;
    MediaPlayer kachingSound;
    MediaPlayer bottleFallingSound;
    MediaPlayer insertCoinSound;

    BottleDispenser bottleDispenser = com.example.vendingmachine.BottleDispenser.getInstance();
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        balanceField = findViewById(R.id.balance);
        returnButton = findViewById(R.id.buttonReturn);
        balanceField.setText(Double.toString(bottleDispenser.getMoneyAmount()));
        outputField = findViewById(R.id.output);
        context = MainActivity.this;
        bottleFallingSound = MediaPlayer.create(this, R.raw.bottle_falling);
        insertCoinSound = MediaPlayer.create(this, R.raw.coin_effect);
        kachingSound = MediaPlayer.create(this, R.raw.coins_dropping);
    }
    public void openAddMoneyDialog(View v){
        openDialog();
    }

    public void openDialog(){
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "dialog");
    }
    private void playKaching(String s){
        if(s.contains("KACHUNK")){
            bottleFallingSound.start();
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void buyButtonPress(View v){
        int id = v.getId();
        String s;
        switch(id){
            case R.id.buyBottle1:
                s = bottleDispenser.buyBottle(1);
                playKaching(s);
                outputField.setText(s);
                break;
            case R.id.buyBottle2:
                s = bottleDispenser.buyBottle(2);
                playKaching(s);
                outputField.setText(s);
                break;
            case R.id.buyBottle3:
                s = bottleDispenser.buyBottle(3);
                playKaching(s);
                outputField.setText(s);
                break;
            case R.id.buyBottle4:
                s = bottleDispenser.buyBottle(4);
                playKaching(s);
                outputField.setText(s);
                break;
        }
        balanceField.setText(Double.toString(Math.round(bottleDispenser.getMoneyAmount())));
    }

    public void addMoney(double amount){
        insertCoinSound.start();
        bottleDispenser.addMoney(amount);
        String amt = Double.toString(bottleDispenser.getMoneyAmount());
        balanceField.setText(amt);
    }
    public void returnMoney(View v){
        double money = bottleDispenser.returnMoney();
        if(money <= 0){
            outputField.setText("There is no money to return");
        }
        else {
            kachingSound.start();
            balanceField.setText(Double.toString(bottleDispenser.getMoneyAmount()));
            outputField.setText("Kaching!" + " You got " + String.format("%.2f", money) + "€ back");
        }




    }




}