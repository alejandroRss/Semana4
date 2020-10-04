package com.farussif.semana3.adapter;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farussif.semana3.pojo.Contacto;
import com.farussif.semana3.R;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ContactoViewHolder>{
    ArrayList<Contacto> contactos;
    Activity activity;


    //Metodo constructor que pasa la lista
    public Adaptador (ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;

    }


    @NonNull
    @Override
    //Inflar layout y lo pasara al ViewHolder para que obtenga cada elemento
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);//Le da vida al layout se busca asociar al recycler view
        return new ContactoViewHolder(v);
    }

    //asocia cada elemento de la vista con cada view
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {//setear valores de la lista
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvRaitingCV.setText(contacto.getCantidadRaiting());
        contactoViewHolder.imgRaitingBone.setImageResource(contacto.getHuesoRaitingBlanco());
        contactoViewHolder.imgBoneYellow.setImageResource(contacto.getHuesoYellow());
        //contactoViewHolder.btRaitingBone.setBackgroundResource(contacto.getHuesoRaitingBlanco());



        contactoViewHolder.imgRaitingBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Like para "+contacto.getNombre(),Toast.LENGTH_SHORT).show();



                /*
                Intent intent = new Intent(activity,DetalleContacto.class);

                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("correo",contacto.getCorreo());
                activity.startActivity(intent);*/
            }
        });



    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene la lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvRaitingCV;
        private ImageView imgRaitingBone;
        private ImageView imgBoneYellow;
        //private Button btRaitingBone;


        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRaitingCV = (TextView) itemView.findViewById(R.id.tvRaitingCV);
            imgBoneYellow = (ImageView)itemView.findViewById(R.id.imgdogBoneYellow);
            imgRaitingBone = (ImageView)itemView.findViewById(R.id.imgdogBoneWhite);
            //btRaitingBone = (Button)itemView.findViewById(R.id.btBoneWhite);
        }
    }
}

