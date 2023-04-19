package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class fragmentVender extends Fragment {

    ImageView Herra_1, Herra_2, Herra_3, Herra_4, Herra_5, Herra_6;
    TextView Ir_Acerca, Ir_Cliente;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View Mostrar = inflater.inflate(R.layout.activity_fragment_vender, container, false);
        Herra_1 = Mostrar.findViewById(R.id.Produt1);
        Herra_2 = Mostrar.findViewById(R.id.Produt2);
        Herra_3 = Mostrar.findViewById(R.id.Produt3);
        Herra_4 = Mostrar.findViewById(R.id.Produt4);
        Herra_5 = Mostrar.findViewById(R.id.Produt5);
        Herra_6 = Mostrar.findViewById(R.id.Produt6);
        Ir_Cliente = Mostrar.findViewById(R.id.Cliente1);
        Ir_Acerca = Mostrar.findViewById(R.id.Acerca1);
        Herra_1.setImageResource(R.drawable.mouse);
        Herra_2.setImageResource(R.drawable.teclado);
        Herra_3.setImageResource(R.drawable.kit);
        Herra_4.setImageResource(R.drawable.rj45);
        Herra_5.setImageResource(R.drawable.conectores);
        Herra_6.setImageResource(R.drawable.aire);
        Ir_Cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contactar_T();
            }
        });
        Ir_Acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Go_Abrir();
            }
        });
        Herra_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        Herra_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        Herra_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        Herra_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        Herra_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        Herra_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VEr_Ventana();
            }
        });
        return  Mostrar;
    }
    // Atención al cliente.
    public void Contactar_T(){
        String mensaje = "";
        String contacto = "+50373707524";
        Uri abrir = Uri.parse("http://wa.me/" + contacto + "/?text=" + mensaje);
        Intent Whatapp = new Intent(Intent.ACTION_VIEW, abrir);
        startActivity(Whatapp);
    }
    // Método para la ventana de opción de compra.
    public void VEr_Ventana() {
        AlertDialog.Builder Mostrar_ventana = new AlertDialog.Builder(getContext());
        Mostrar_ventana.setTitle("COMPRA SST PRODUCTO");
        Mostrar_ventana.setMessage("¿Desea comprar este producto?");
        Mostrar_ventana.setCancelable(false);
        Mostrar_ventana.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Mos_Pago();
            }
        });
        Mostrar_ventana.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog abrir =Mostrar_ventana.create();
        abrir.show();
    }
    // Método para el pago.
    public void Mos_Pago(){
        Intent Ver_Accp = new Intent(getActivity(), Pagar.class);
        startActivity(Ver_Accp);
    }
    public void Go_Abrir(){
        Intent Ver_Acc = new Intent(getActivity(), activity_acerca_de.class);
        startActivity(Ver_Acc);
    }
}
