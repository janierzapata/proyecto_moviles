package com.example.restaurantesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Index extends AppCompatActivity {

    private ImageView imag1, imag2;

    boolean state =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        imag1 = (ImageView)findViewById(R.id.img1);
        imag2 = (ImageView)findViewById(R.id.img2);
    }

    public void next(View v) {
        if (state){
            imag1.setVisibility(View.INVISIBLE);
            imag2.setVisibility(View.VISIBLE);
            state = false;
        }else{
            imag1.setVisibility(View.VISIBLE);
            imag2.setVisibility(View.INVISIBLE);
            state = true;
        }
    }

    public void back(View v) {
        if (state){
            imag1.setVisibility(View.INVISIBLE);
            imag2.setVisibility(View.VISIBLE);
            state = false;
        }else{
            imag1.setVisibility(View.VISIBLE);
            imag2.setVisibility(View.INVISIBLE);
            state = true;
        }
    }
}