package com.farussif.semana3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farussif.semana3.pojo.Contacto;
import com.farussif.semana3.R;
import com.farussif.semana3.adapter.Adaptador;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Contacto> contactos;
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container,false); //Equivale al setContentView de la clase Main
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvContactos);


        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        InicializarListaContactos();
        InicializarAdaptador();


        return v;
    }
    public void InicializarAdaptador(){
        Adaptador adaptador = new Adaptador(contactos, getActivity());
        listaMascotas.setAdapter(adaptador);
    }
    public void InicializarListaContactos(){

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.cat1,"Félix","8",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.dog1,"Arwen","2",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.cat2,"Kitty","4",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.dog2,"Andy","1",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.cat3,"Anubis","2",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.dog3,"Geisha","11",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.cat4,"Tiger","6",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.dog4,"Dafnis","9",R.drawable.dog_bone,R.drawable.dog_bone_yellow));

    }

}
