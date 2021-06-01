package com.example.restaurantesqlite;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class Reservas extends AppCompatActivity {


    // Obtener referencia al EditText
    private EditText etFecha, etHora, etNombre, etAsistentes;

    // Guardar el último año, mes y día del mes
    private int ultimoAnio, ultimoMes, ultimoDiaDelMes, hora, minutos;


    // Crear un listener del datepicker;
    private DatePickerDialog.OnDateSetListener listenerDeDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int anio, int mes, int diaDelMes) {
            // Esto se llama cuando seleccionan una fecha. Nos pasa la vista, pero más importante, nos pasa:
            // El año, el mes y el día del mes. Es lo que necesitamos para saber la fecha completa


            // Refrescamos las globales
            ultimoAnio = anio;
            ultimoMes = mes;
            ultimoDiaDelMes = diaDelMes;

            // Y refrescamos la fecha
            refrescarFechaEnEditText();

        }
    };

    private TimePickerDialog.OnTimeSetListener ListenerTimePicker = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hora = hourOfDay;
            minutos = minute;

            refrescarHoraEnEditText();
        }
    };

    public void refrescarFechaEnEditText() {
        // Formateamos la fecha pero podríamos hacer cualquier otra cosa ;)
        String fecha = String.format(Locale.getDefault(), "%02d-%02d-%02d", ultimoAnio, ultimoMes + 1, ultimoDiaDelMes);

        // La ponemos en el editText
        etFecha.setText(fecha);
    }

    public void refrescarHoraEnEditText() {
        // Formateamos la fecha pero podríamos hacer cualquier otra cosa ;)
        String fecha = String.format(Locale.getDefault(), "%02d:%02d", hora, minutos);

        // La ponemos en el editText
        etHora.setText(fecha);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);

        // Instanciar objetos
        etFecha = findViewById(R.id.datePicker);
        etHora = findViewById(R.id.timePicker);
        etNombre = findViewById(R.id.nameRep);
        etAsistentes = findViewById(R.id.numPersn);

        // Poner último año, mes y día a la fecha de hoy
        final Calendar calendario = Calendar.getInstance();
        ultimoAnio = calendario.get(Calendar.YEAR);
        ultimoMes = calendario.get(Calendar.MONTH);
        ultimoDiaDelMes = calendario.get(Calendar.DAY_OF_MONTH);

        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);

        // Refrescar la fecha en el EditText
        refrescarFechaEnEditText();
        refrescarHoraEnEditText();
        // Hacer que el datepicker se muestre cuando toquen el EditText; recuerda
        // que se podría invocar en el click de cualquier otro botón, o en cualquier
        // otro evento

        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí es cuando dan click así que mostramos el DatePicker

                // Le pasamos lo que haya en las globales

                DatePickerDialog dialogoFecha = new DatePickerDialog(Reservas.this, listenerDeDatePicker, ultimoAnio, ultimoMes, ultimoDiaDelMes);
                //Mostrar
                dialogoFecha.show();
            }
        });

        etHora.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Aquí es cuando dan click así que mostramos el DatePicker

                // Le pasamos lo que haya en las globales

                TimePickerDialog dialogoFecha = new TimePickerDialog(Reservas.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hours, int minutes) {
                        etHora.setText(hours + ":" + minutes);
                    }
                }, hora, minutos, false);
                //Mostrar
                dialogoFecha.show();
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menu, m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem i) {
        int itemId = i.getItemId();

        if (itemId == R.id.item_index) {
            Intent intent = new Intent(this, Index.class);
            startActivity(intent);
            this.finish();
        } else if (itemId == R.id.item_reservar) {
            Intent intent = new Intent(this, Reservas.class);
            startActivity(intent);
            this.finish();
        } else if (itemId == R.id.item_editar) {

            Intent intent = new Intent(this, Editar_reservas.class);
            startActivity(intent);
            this.finish();
        } else if (itemId == R.id.item_mis_reservas) {
            Toast.makeText(this, "paso a mis reservas", Toast.LENGTH_SHORT).show();

           /* Intent intent = new Intent(this, Index.class);
            startActivity(intent);
            this.finish();*/
        } else if (itemId == R.id.item_cancelar) {
            Toast.makeText(this, "paso a cancelar reservas", Toast.LENGTH_SHORT).show();

            /*
            Intent intent = new Intent(this, Index.class);
            startActivity(intent);
            this.finish();*/
        } else if (itemId == R.id.item_menu) {
            Intent intent = new Intent(this, Carta.class);
            startActivity(intent);
            this.finish();
        } else if (itemId == R.id.item_salir) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }
        return super.onOptionsItemSelected(i);
    }


   /* public EditText getEtNombre() {
    return etNombre;
    }

    public void setEtNombre(EditText etNombre) {
        this.etNombre = etNombre;
    }

    public EditText getEtAsistentes() {
        return etAsistentes;
    }

    public void setEtAsistentes(EditText etAsistentes) {
        this.etAsistentes = etAsistentes;
    }

    public void reservar (View v){
        AdminSqlite objsql = new AdminSqlite(this);
        SQLiteDatabase db = objsql.getWritableDatabase();


        String nombre_representante = etNombre.getText().toString();
        String asistentes = etAsistentes.getText().toString();
        String dia = etFecha.getText().toString();
        String hora = etHora.getText().toString();

        if(!nombre_representante.isEmpty() && !asistentes.isEmpty() && !dia.isEmpty() && !hora.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("nombre",nombre_representante);
            registro.put("asistentes",asistentes);
            registro.put("Dia",dia);
            registro.put("Hora",hora);

            db.insert("reservas",null,registro);

            db.close();
            etNombre.setText("");
            etAsistentes.setText("");
            etFecha.setText("");
            etHora.setText("");


            Toast.makeText(this,"Registro realizado correctamente",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }


    }*/

    }

