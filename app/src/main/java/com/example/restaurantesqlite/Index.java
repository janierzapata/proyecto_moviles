package com.example.restaurantesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class Index extends AppCompatActivity {

    private ImageView imag1, imag2;
    String id="";

    boolean state =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        id =getIntent().getStringExtra("idUser");


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

    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.menu, m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem i){
        int itemId = i.getItemId();

        if(itemId==R.id.item_index){
            Intent intent = new Intent(this, Index.class);
            intent.putExtra("idUser",id);
            startActivity(intent);
            this.finish();
        }
        else if(itemId==R.id.item_reservar){
            Intent intent = new Intent(this, Reservas.class);
            intent.putExtra("idUser",id);
            startActivity(intent);
            this.finish();
        }

        else if(itemId==R.id.item_mis_reservas){
           Intent intent = new Intent(this, Editar_reservas.class);
            intent.putExtra("idUser",id);
            startActivity(intent);
            this.finish();
        }

        else if(itemId==R.id.item_menu){
            Intent intent = new Intent(this, Carta.class);
            intent.putExtra("idUser",id);
            startActivity(intent);
            this.finish();
        }
        else if(itemId==R.id.item_salir){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }
        return super.onOptionsItemSelected(i);
    }
}