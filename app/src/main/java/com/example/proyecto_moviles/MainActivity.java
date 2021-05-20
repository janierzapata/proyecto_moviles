package com.example.proyecto_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {


    private EditText name;
    private EditText pass;
    private EditText tel;
    private EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        name = (EditText) findViewById(R.id.User_name);
        pass = (EditText) findViewById(R.id.User_pass);
        tel = (EditText) findViewById(R.id.cel);
        email =(EditText) findViewById(R.id.Useremail);

    }

    public void check(View view){
        //metodo para validar el login

    }

    public void pasar_reg(View view){
        Intent Vregistro = new Intent(this, Registrar.class);
        startActivity(Vregistro);
    }


}