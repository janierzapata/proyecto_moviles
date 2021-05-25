package com.example.restaurantesqlite;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {


    private EditText name;
    private EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        name = (EditText)findViewById(R.id.User_name);
        pass = (EditText)findViewById(R.id.User_pass);
    }

    public void pasar(View v){
       Intent intent = new Intent(this, Registrar.class);
       startActivity(intent);
       this.finish();
    }

    public void Buscar (View v){

        Intent intent = new Intent(this, Index.class);
        startActivity(intent);
        this.finish();

        /*AdminSqlite objsql = new AdminSqlite(this,"administrator", null, 1);
        SQLiteDatabase db = objsql.getWritableDatabase();

        String nombre = name.getText().toString();
        String contraseña = pass.getText().toString();


        if(!nombre.isEmpty() && !contraseña.isEmpty()){
            Cursor fila = db.rawQuery("select id from usuarios where nombre="+nombre +"&& contraseña="+contraseña, null);
            if(fila.moveToFirst()){

                String id = fila.getString(0);
                Intent i = new Intent(this, Reservas.class);
                intent.putExtra("id",id);
                startActivity(i);

                db.close();
            }else{
                Toast.makeText(this, "Este producto no existe", Toast.LENGTH_SHORT).show();
                db.close();
            }
        }else{
            Toast.makeText(this, "Debes poner un codigo", Toast.LENGTH_SHORT).show();

        }*/
    }

}
