package com.example.quickstart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Pregunta2 extends AppCompatActivity {
    Button btnvolver;
    TextView textView;
    GuardarDatos datos;
    String seleccionado;
    TextView imagen1,imagen2,imagen3,imagen4,imagen5,txt;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta2);
        btnvolver = (Button)findViewById(R.id.BTNatras1);
        datos = GuardarDatos.instancia;
        final ArrayList<String> opcion2 = datos.getOpciones2();
        txt = (TextView) findViewById(R.id.textView2);
        txt.setText(Html.fromHtml(getResources().getString(R.string.pregunta2)));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006064")));
        imagen1 = (TextView) findViewById(R.id.imagen1);
        imagen2 = (TextView) findViewById(R.id.imagen2);
        imagen3 = (TextView) findViewById(R.id.imagen3);
        imagen4 = (TextView) findViewById(R.id.imagen4);
        imagen5 = (TextView) findViewById(R.id.imagen5);
        databaseReference= FirebaseDatabase.getInstance().getReference();

        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen1.getText().toString();
                if (! isDeviceOnline()) {
                    Encuesta p1 = new Encuesta(seleccionado);
                    databaseReference.child(Integer.toString(MainActivity.contador)).child("3").setValue(seleccionado);
                }
                datos.getOpciones2().add(seleccionado);
                Intent myintent = new Intent(getApplicationContext(),Pregunta3.class);
                startActivity(myintent);
            }
        });

        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen2.getText().toString();
                if (! isDeviceOnline()) {
                    Encuesta p1 = new Encuesta(seleccionado);
                    databaseReference.child(Integer.toString(MainActivity.contador)).child("3").setValue(seleccionado);
                }
                datos.getOpciones2().add(seleccionado);
                Intent myintent = new Intent(getApplicationContext(),Pregunta3.class);
                startActivity(myintent);
            }
        });

        imagen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen3.getText().toString();
                if (! isDeviceOnline()) {
                    Encuesta p1 = new Encuesta(seleccionado);
                    databaseReference.child(Integer.toString(MainActivity.contador)).child("3").setValue(seleccionado);
                }
                datos.getOpciones2().add(seleccionado);
                Intent myintent = new Intent(getApplicationContext(),Pregunta3.class);
                startActivity(myintent);
            }
        });

        imagen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen4.getText().toString();
                if (! isDeviceOnline()) {
                    Encuesta p1 = new Encuesta(seleccionado);
                    databaseReference.child(Integer.toString(MainActivity.contador)).child("3").setValue(seleccionado);
                }
                datos.getOpciones2().add(seleccionado);
                Intent myintent = new Intent(getApplicationContext(),Pregunta3.class);
                startActivity(myintent);
            }
        });

        imagen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen5.getText().toString();
                if (! isDeviceOnline()) {
                    Encuesta p1 = new Encuesta(seleccionado);
                    databaseReference.child(Integer.toString(MainActivity.contador)).child("3").setValue(seleccionado);
                }
                datos.getOpciones2().add(seleccionado);
                Intent myintent = new Intent(getApplicationContext(),Pregunta3.class);
                startActivity(myintent);
            }
        });

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones2().clear();
                datos.getOpciones().clear();
                Intent myintent = new Intent(getApplicationContext(),Pregunta1.class);
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
