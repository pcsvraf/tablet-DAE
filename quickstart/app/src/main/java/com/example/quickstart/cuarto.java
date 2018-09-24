package com.example.quickstart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class cuarto extends AppCompatActivity {
    TextView textView;
    Button boton4;
    PrincipalActivity tiempo;
    GuardarDatos datos;
    String seleccionado;
    TextView imagen1,imagen2,imagen3,imagen4,imagen5,txt;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarto);
        boton4 = (Button) findViewById(R.id.boton4);
        tiempo = PrincipalActivity.intancia;
        datos = GuardarDatos.instancia;
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006064")));
        final ArrayList<String> opciones = datos.getOpciones6();
        imagen1 = (TextView) findViewById(R.id.imagen1);
        imagen2 = (TextView) findViewById(R.id.imagen2);
        imagen3 = (TextView) findViewById(R.id.imagen3);
        imagen4 = (TextView) findViewById(R.id.imagen4);
        imagen5 = (TextView) findViewById(R.id.imagen5);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        txt = (TextView) findViewById(R.id.textView3);
        txt.setText(Html.fromHtml(getResources().getString(R.string.cuarto)));

        if (primero.seleccionado1.equals("Servicio Social")) {
            txt.setText(Html.fromHtml(getResources().getString(R.string.cuarto)));
        }
        else if (primero.seleccionado1.equals("Servicio Médico Estudiantil")){
            txt.setText(Html.fromHtml(getResources().getString(R.string.cuarto1)));
        }
        else if (primero.seleccionado1.equals("Atención Dental")){
            txt.setText(Html.fromHtml(getResources().getString(R.string.cuarto2)));
        }
        else if (primero.seleccionado1.equals("Atención Psicoeducativa")){
            txt.setText(Html.fromHtml(getResources().getString(R.string.cuarto3)));
        }
        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen1.getText().toString();
                if (! isDeviceOnline()) {
                    Encuesta p1 = new Encuesta(seleccionado);
                    databaseReference.child(Integer.toString(MainActivity.contador)).child("6").setValue(seleccionado);
                }
                datos.getOpciones6().add(seleccionado);
                datos.getOpciones7().clear();
                Intent intet = new Intent(getApplicationContext(),quinto.class);
                startActivity(intet);
            }
        });

        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones7().clear();
                seleccionado = imagen2.getText().toString();
                if (! isDeviceOnline()) {
                    Encuesta p1 = new Encuesta(seleccionado);
                    databaseReference.child(Integer.toString(MainActivity.contador)).child("6").setValue(seleccionado);
                }
                datos.getOpciones6().add(seleccionado);
                Intent intet = new Intent(getApplicationContext(),quinto.class);
                startActivity(intet);
            }
        });

        imagen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones7().clear();
                seleccionado = imagen3.getText().toString();
                if (! isDeviceOnline()) {
                    Encuesta p1 = new Encuesta(seleccionado);
                    databaseReference.child(Integer.toString(MainActivity.contador)).child("6").setValue(seleccionado);
                }
                datos.getOpciones6().add(seleccionado);
                Intent intet = new Intent(getApplicationContext(),quinto.class);
                startActivity(intet);
            }
        });

        imagen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones7().clear();
                seleccionado = imagen4.getText().toString();
                if (! isDeviceOnline()) {
                    Encuesta p1 = new Encuesta(seleccionado);
                    databaseReference.child(Integer.toString(MainActivity.contador)).child("6").setValue(seleccionado);
                }
                datos.getOpciones6().add(seleccionado);
                Intent intet = new Intent(getApplicationContext(),quinto.class);
                startActivity(intet);
            }
        });

        imagen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones7().clear();
                seleccionado = imagen5.getText().toString();
                if (! isDeviceOnline()) {
                    Encuesta p1 = new Encuesta(seleccionado);
                    databaseReference.child(Integer.toString(MainActivity.contador)).child("6").setValue(seleccionado);
                }
                datos.getOpciones6().add(seleccionado);
                Intent intet = new Intent(getApplicationContext(),quinto.class);
                startActivity(intet);
            }
        });

        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones9().clear();
                datos.getOpciones6().clear();
                Intent myintent = new Intent(getApplicationContext(),corte.class);
                startActivity(myintent);
            }
        });
    }
    private boolean isDeviceOnline() {
        ConnectivityManager connMgr =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}