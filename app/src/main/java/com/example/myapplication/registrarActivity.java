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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class registrarActivity extends AppCompatActivity {

    private Button crearcuenta;
    private EditText Name, Telefono, contra;
    private ProgressDialog loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        crearcuenta = (Button) findViewById(R.id.registrarse_btn);
        Name = (EditText) findViewById(R.id.registrar_usuar);
        Telefono = (EditText) findViewById(R.id.registrar_numero_telefono);
        contra = (EditText) findViewById(R.id.resgistro_password);
        loadingbar = new ProgressDialog(this);

       crearcuenta.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Crearcuentas();
           }
       });
    }


    private void Crearcuentas(){
        String nombre = Name.getText().toString();
        String telefonos = Telefono.getText().toString();
        String contrasena = contra.getText().toString();

        if (TextUtils.isEmpty(nombre)){
            Toast.makeText(this, "Escribe un usuario", Toast.LENGTH_SHORT).show();
        }

       else if (TextUtils.isEmpty(telefonos)){
            Toast.makeText(this, "Escribe su numero de telefono", Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(contrasena)){
            Toast.makeText(this, "Escribe una contraseña", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingbar.setTitle("Cuenta creada con exito");
            loadingbar.setMessage("Espera, por favor revisa los datos");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();

            validarlosdatos(nombre,telefonos,contrasena);
        }

    }

    private void validarlosdatos(String nombre,final String telefonos, String contrasena) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if (!(datasnapshot.child("Users").child(telefonos).exists()))
                {
                    HashMap<String, Object> userdatamap = new HashMap<>();
                    userdatamap.put("telefono",telefonos);
                    userdatamap.put("Nombre",nombre);
                    userdatamap.put("contraseña",contrasena);

                    RootRef.child("Usuarios").child(telefonos).updateChildren(userdatamap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText(registrarActivity.this, "Cuanta creada con exito", Toast.LENGTH_SHORT).show();
                                        loadingbar.dismiss();
                                        Intent intent = new Intent(registrarActivity.this, loginActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        loadingbar.dismiss();
                                        Toast.makeText(registrarActivity.this, "ERROR 404 problemas de red : por favor intente mas tarde...", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else
                {
                    Toast.makeText(registrarActivity.this, "El numero"+ telefonos + "ya esta registrado", Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();
                    Toast.makeText(registrarActivity.this, "Por favor prueba con otro numero", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(registrarActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}