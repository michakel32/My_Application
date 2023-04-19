package com.example.myapplication;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;


import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class fragment_promocion extends Fragment {

    ImageView P1, P2, P3, P4, P5, P6;
    TextView Ir_Acerca3, Ir_Cliente3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View prom = inflater.inflate(R.layout.activity_fragment_calificar, container, false);
        P1 = prom.findViewById(R.id.P1);
        P2 = prom.findViewById(R.id.P2);
        P3 = prom.findViewById(R.id.P3);
        P4 = prom.findViewById(R.id.P4);
        P5 = prom.findViewById(R.id.P5);
        P6 = prom.findViewById(R.id.P6);
        Ir_Cliente3 = prom.findViewById(R.id.Cliente3);
        Ir_Acerca3 = prom.findViewById(R.id.Acerca3);

        P1.setImageResource(R.drawable.camara);
        P2.setImageResource(R.drawable.controles);
        P3.setImageResource(R.drawable.desoorante);
        P4.setImageResource(R.drawable.sanboy);
        P5.setImageResource(R.drawable.sandalias);
        P6.setImageResource(R.drawable.reloj);
        Ir_Cliente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactarW();
            }
        });
        Ir_Acerca3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Abri_Frame3();
            }
        });
        P1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        P3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        P4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        P5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        P6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        return prom;
    }
    public void ContactarW(){
        String mensaje = "";
        String contacto = "+50373707524";
        Uri abrir = Uri.parse("http://wa.me/" + contacto + "/?text=" + mensaje);
        Intent Whatapp = new Intent(Intent.ACTION_VIEW, abrir);
        startActivity(Whatapp);
    }
    // Método para la ventana de opción de compra.
    public void VEr_Ventana() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(getContext());
        ventana.setTitle("COMPRA SST PRODUCTO")
                .setMessage("¿Desea comprar este producto?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Pago();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog abrir =ventana.create();
        abrir.show();
    }
    // Método para el pago.
    public void Pago (){
        Intent Ver_Acc = new Intent(getActivity(), Pagar.class);
        startActivity(Ver_Acc);
    }
    public void Abri_Frame3(){
        Intent frame = new Intent(getActivity(), activity_acerca_de.class);
        startActivity(frame);
    }
}