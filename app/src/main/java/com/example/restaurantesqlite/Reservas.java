package com.example.restaurantesqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantesqlite.R;

public class Reservas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);
    }

    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.menu, m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem i){
        int itemId = i.getItemId();

        if(itemId==R.id.item_index){
            Intent intent = new Intent(this, Index.class);
            startActivity(intent);
            this.finish();
        }
        else if(itemId==R.id.item_reservar){
            Intent intent = new Intent(this, Reservas.class);
            startActivity(intent);
            this.finish();
        }
        else if(itemId==R.id.item_editar){

            Toast.makeText(this,"paso a editar",Toast.LENGTH_SHORT).show();
            /*Intent intent = new Intent(this, Index.class);
            startActivity(intent);
            this.finish();*/
        }
        else if(itemId==R.id.item_mis_reservas){
            Toast.makeText(this,"paso a mis reservas",Toast.LENGTH_SHORT).show();

           /* Intent intent = new Intent(this, Index.class);
            startActivity(intent);
            this.finish();*/
        }
        else if(itemId==R.id.item_cancelar){
            Toast.makeText(this,"paso a cancelar reservas",Toast.LENGTH_SHORT).show();

            /*
            Intent intent = new Intent(this, Index.class);
            startActivity(intent);
            this.finish();*/
        }
        else if(itemId==R.id.item_menu){
            Toast.makeText(this,"paso a menu",Toast.LENGTH_SHORT).show();

            /*
            Intent intent = new Intent(this, Index.class);
            startActivity(intent);
            this.finish();*/
        }else if(itemId==R.id.item_salir){

            this.finish();
        }
        return super.onOptionsItemSelected(i);
    }
}