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

public class corte extends AppCompatActivity {
    TextView textView;
    Button boton9;
    PrincipalActivity tiempo;
    GuardarDatos datos;
    public static String seleccionado2;
    TextView imagen1, imagen2, txt;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corte);
        boton9 = (Button) findViewById(R.id.boton9);
        tiempo = PrincipalActivity.intancia;
        datos = GuardarDatos.instancia;
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006064")));
        final ArrayList<String> opciones = datos.getOpciones9();
        imagen1 = (TextView) findViewById(R.id.like);
        imagen2 = (TextView) findViewById(R.id.dislike);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        txt = (TextView) findViewById(R.id.textView9);

        if (primero.seleccionado1.equals("Servicio Social")) {
            txt.setText(Html.fromHtml(getResources().getString(R.string.corte)));
        }
        else if (primero.seleccionado1.equals("Servicio Médico Estudiantil")){
            txt.setText(Html.fromHtml(getResources().getString(R.string.corte1)));
        }
        else if (primero.seleccionado1.equals("Atención Dental")){
            txt.setText(Html.fromHtml(getResources().getString(R.string.corte2)));
        }
        else if (primero.seleccionado1.equals("Atención Psicoeducativa")){
            txt.setText(Html.fromHtml(getResources().getString(R.string.corte3)));
        }

        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado2 = imagen1.getText().toString();
                if (!isDeviceOnline()) {
                    Encuesta p1 = new Encuesta(seleccionado2);
                    databaseReference.child(Integer.toString(MainActivity.contador)).child("5").setValue(seleccionado2);
                }
                datos.getOpciones9().add(seleccionado2);
                datos.getOpciones6().clear();
                Intent intet = new Intent(getApplicationContext(), cuarto.class);
                startActivity(intet);
            }
        });

        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones6().clear();
                seleccionado2 = imagen2.getText().toString();
                if (!isDeviceOnline()) {
                    Encuesta p1 = new Encuesta(seleccionado2);
                    databaseReference.child(Integer.toString(MainActivity.contador)).child("5").setValue(seleccionado2);
                }
                datos.getOpciones9().add(seleccionado2);
                Intent intet = new Intent(getApplicationContext(), Pregunta6.class);
                startActivity(intet);
            }
        });

        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones9().clear();
                datos.getOpciones3().clear();
                Intent myintent = new Intent(getApplicationContext(), Pregunta3.class);
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