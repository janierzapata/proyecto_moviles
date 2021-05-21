package com.example.proyecto_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText User_name;
    EditText User_pass;
    EditText User_tel;
    EditText User_email;
    Button btnregistrar;

    RequestQueue requestQueue;

    private static final String URL1 = "http://192.168.100.4/proyectapp/save.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        requestQueue = Volley.newRequestQueue(this);

        initUI();
        btnregistrar.setOnClickListener(this);



    }

        private void initUI() {
        User_name = (EditText) findViewById(R.id.User_name);
        User_pass = (EditText) findViewById(R.id.User_pass);
        User_tel = (EditText) findViewById(R.id.cel);
        User_email = (EditText) findViewById(R.id.Useremail);

        btnregistrar = findViewById(R.id.btn_registrar);




    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btn_registrar) {
            String name = User_name.getText().toString().trim();
            String pass = User_pass.getText().toString().trim();
            String email = User_email.getText().toString().trim();
            String tel = User_tel.getText().toString().trim();

            registraruser(name,pass,email,tel);



        } else if (id == R.id.btn_redir_register ) {

        }
    }

    private void registraruser(final String name, final String pass,final String email,final String tel) {

        StringRequest stringRequest  = new StringRequest(

                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }


        ){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params=new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("pass", pass);
                params.put("phone",tel);
                return params;
            }
        };
        requestQueue.add(stringRequest);



    }

    public void pasar_registro(View view){
        Intent ingreso = new Intent(this,Registrar.class);
        startActivity(ingreso);
    }


}
