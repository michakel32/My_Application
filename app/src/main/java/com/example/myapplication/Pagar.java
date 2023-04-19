package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Pagar extends AppCompatActivity {

    EditText nombre, tarjetanum, cvv, fechavencimiento;

    Button continuar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);
        nombre = findViewById(R.id.nombre);
        tarjetanum = findViewById(R.id.tarjetanum);
        cvv = findViewById(R.id.cvv);
        continuar = findViewById(R.id.button);
        fechavencimiento = findViewById(R.id.fechavencimiento);

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrir_pago();
            }
        });

    }
    public void abrir_pago(){
        Intent intent = new Intent(Pagar.this, Recibo.class);
        startActivity(intent);
        finish();
    }
}



