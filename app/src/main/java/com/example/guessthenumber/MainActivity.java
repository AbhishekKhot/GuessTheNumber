package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.media.effect.EffectFactory;
import android.os.Bundle;
import android.os.Message;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
    }

    public void generateRandomNumber(){
        Random rand = new Random();
        randomNumber = rand.nextInt(100)+1;
    }

    public void guess(View view) {
        EditText editText = (EditText)  findViewById(R.id.editText);

        int guessValue = Integer.parseInt(editText.getText().toString());

        String MessageToDisplay;

        if(guessValue > randomNumber){
            MessageToDisplay = "Try lower number!";
        }
        else if(guessValue < randomNumber){
            MessageToDisplay = "Try higher number!";
        }
        else{
            MessageToDisplay = "You got it correct! Try again!";
        }

       Toast.makeText(this, MessageToDisplay, Toast.LENGTH_SHORT).show();

        Log.i("Entered value", editText.getText().toString());
        Log.i("Random Number", Integer.toString(randomNumber));
    }
}