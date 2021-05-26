package com.example.restaurantesqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registrar extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private EditText tel;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        name = (EditText)findViewById(R.id.User_name);
        pass = (EditText)findViewById(R.id.User_pass);
        tel = (EditText)findViewById(R.id.cel);
        email = (EditText)findViewById(R.id.Useremail);



    }


    public void agregar (View v) {
        AdminSqlite objsql = new AdminSqlite(this);
        SQLiteDatabase db = objsql.getWritableDatabase();

        String nombreUsuario = name.getText().toString();
        String contraseña = pass.getText().toString();
        String celular = tel.getText().toString();
        String correo = email.getText().toString();

        if(!nombreUsuario.isEmpty() && !contraseña.isEmpty() && !celular.isEmpty() && !correo.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("nombre",nombreUsuario);
            registro.put("contraseña",contraseña);
            registro.put("celular",celular);
            registro.put("email",correo);

            db.insert("usuarios",null,registro);

            db.close();
            name.setText("");
            pass.setText("");
            tel.setText("");
            email.setText("");


            Toast.makeText(this,"Registro realizado correctamente",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

        
    }



    public void pasar_login(View view){

        Intent ingreso = new Intent(this,MainActivity.class);
        startActivity(ingreso);
        this.finish();
    }


}