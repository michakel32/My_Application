package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Model.James;
import Prevalent.prevalent;
import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {


    private Button joinnowButton, loginButton;
    private ProgressDialog loadingbar;
    private String parenDBName = "Usuarios";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        joinnowButton = findViewById(R.id.main_join_now_btn);
        loginButton = findViewById(R.id.main_login_btn);
        loadingbar = new ProgressDialog(this);

        Paper.init(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });

        joinnowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, registrarActivity.class);
                startActivity(intent);
            }
        });

        String Usertelfokey = Paper.book().read(prevalent.USertelfoKey);
        String Userpasswodkey = Paper.book().read(prevalent.USerpasswodKey);

        if (Usertelfokey != "" && Userpasswodkey != ""){
            if (!TextUtils.isEmpty(Usertelfokey) && !TextUtils.isEmpty(Userpasswodkey)){
                accesosiempre(Userpasswodkey,Usertelfokey);

                loadingbar.setTitle("Iniciando");
                loadingbar.setMessage("Por favor espere...");
                loadingbar.setCanceledOnTouchOutside(false);
                loadingbar.show();
            }
        }

    }

    private void accesosiempre(final String contrasena,final String telefonos) {

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
                            Toast.makeText(MainActivity.this, "Bienvenido...", Toast.LENGTH_SHORT).show();
                            loadingbar.dismiss();
                            Intent intent = new Intent(MainActivity.this, MainActivityhome2.class);
                            startActivity(intent);
                        }else {
                            loadingbar.dismiss();
                            Toast.makeText(MainActivity.this, "La contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                else {
                    Toast.makeText( MainActivity.this, "La cuenta con el numero " + telefonos +" no existe", Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();
                    Toast.makeText(MainActivity.this, "Necesita crear una cuenta para acceder", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}