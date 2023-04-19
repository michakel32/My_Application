package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Recibo extends AppCompatActivity {

    TextView nombre, tarjeta, cvv, fecha;
    Button Regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo);
        nombre = findViewById(R.id.vernombre);
        tarjeta = findViewById(R.id.vertarjeta);
        cvv = findViewById(R.id.vercvv);
        fecha = findViewById(R.id.verfecha);
        Regresar = findViewById(R.id.button2);
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Back();
            }
        });
    }
    public void Back(){
        finish();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Bundle Observar = getIntent().getExtras();
        if (Observar!= null){
            String ViewNombre = Observar.getString("Nombre");
            String ViewTarjeta = Observar.getString("Tarjeta");
            double ViewCvv = Observar.getDouble("Cvv");
            double ViewFecha = Observar.getDouble("Fecha");
            nombre.setText("Nombre"+ ViewNombre);
            tarjeta.setText("Tarjeta" +ViewTarjeta);
            cvv.setText("CVV "+ViewCvv);
            fecha.setText("Fecha de expiración "+ViewFecha);
        }

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Ver_Acc = new Intent(Recibo.this, MainActivityhome2.class);
                startActivity(Ver_Acc);
            }
        });
    }
}