package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import Model.James;
import Prevalent.prevalent;
import io.paperdb.Paper;

public class loginActivity extends AppCompatActivity {

    private EditText ingrenumero, ingrepassword;
    private Button iniciarbtn;
    private ProgressDialog loadingbar;
    private String parenDBName = "Usuarios";
    private CheckBox chboxremecuerdame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniciarbtn = (Button) findViewById(R.id.login_btn);
        ingrenumero = (EditText) findViewById(R.id.login_numero_telefono);
        ingrepassword = (EditText) findViewById(R.id.login_password);
        loadingbar = new ProgressDialog(this);

        chboxremecuerdame = (CheckBox) findViewById(R.id.recordar_checkbox);
        Paper.init(this);

        iniciarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });
    }

    private void LoginUser() {
        String telefonos = ingrenumero.getText().toString();
        String contrasena = ingrepassword.getText().toString();

        if (TextUtils.isEmpty(telefonos)){
            Toast.makeText(this, "Escribe su numero de telefono", Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(contrasena)){
            Toast.makeText(this, "Escribe una contraseña", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingbar.setTitle("Inicio de seccion en proceso");
            loadingbar.setMessage("Espera, por favor revisa los datos");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();

            paralaDBdeusers(telefonos, contrasena);
        }

    }

    private void paralaDBdeusers(String telefonos, String contrasena) {
        if (chboxremecuerdame.isChecked()){
            Paper.book().write(prevalent.USertelfoKey, telefonos);
            Paper.book().write(prevalent.USerpasswodKey, contrasena);
        }

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
            if (datasnapshot.child(parenDBName).child(telefonos).exists()){

                James usersData = datasnapshot.child(parenDBName).child(telefonos).getValue(James.class);

                if (usersData.getTelefono().equals(telefonos))
                {
                    if (usersData.getContraseña().equals(contrasena))
                    {
                        Toast.makeText(loginActivity.this, "Bienvenido...", Toast.LENGTH_SHORT).show();
                        loadingbar.dismiss();
                        Intent intent = new Intent(loginActivity.this, MainActivityhome2.class);
                        startActivity(intent);
                    }else {
                        loadingbar.dismiss();
                        Toast.makeText(loginActivity.this, "La contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }

            }
            else {
                Toast.makeText(loginActivity.this, "La cuenta con el numero " + telefonos +" no existe", Toast.LENGTH_SHORT).show();
                loadingbar.dismiss();
                Toast.makeText(loginActivity.this, "Necesita crear una cuenta para acceder", Toast.LENGTH_SHORT).show();
            }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}