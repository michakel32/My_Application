package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
public class fragment_activity_Calificar extends Fragment {

    ImageView Ca1, Ca2, Ca3, Ca4, Ca5, Ca6;
    TextView Ir_Acerca2, Ir_Cliente2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View cali= inflater.inflate(R.layout.activity_fragment_calificar, container, false);
        Ca1 = cali.findViewById(R.id.C1);
        Ca2 = cali.findViewById(R.id.C2);
        Ca3 = cali.findViewById(R.id.C3);
        Ca4 = cali.findViewById(R.id.C4);
        Ca5 = cali.findViewById(R.id.C5);
        Ca6 = cali.findViewById(R.id.C6);
        Ir_Cliente2 = cali.findViewById(R.id.Cliente2);
        Ir_Acerca2= cali.findViewById(R.id.Acerca2);
        Ca1.setImageResource(R.drawable.audi);
        Ca2.setImageResource(R.drawable.accesorios);
        Ca3.setImageResource(R.drawable.jordan);
        Ca4.setImageResource(R.drawable.laptop);
        Ca5.setImageResource(R.drawable.ropero);
        Ca6.setImageResource(R.drawable.samsung);
        Ir_Cliente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactarW();
            }
        });
        Ir_Cliente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Abrir_Frame();
            }
        });
        Ca1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        Ca2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        Ca3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        Ca4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        Ca5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        Ca6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        return cali;
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
    public void Abrir_Frame(){
        Intent Ver_Acc = new Intent(getActivity(), activity_acerca_de.class);
        startActivity(Ver_Acc);
    }
}