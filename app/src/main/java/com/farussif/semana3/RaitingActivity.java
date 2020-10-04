package com.farussif.semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.farussif.semana3.adapter.Adaptador;
import com.farussif.semana3.pojo.Contacto;

import java.util.ArrayList;

public class RaitingActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos2;
    private RecyclerView listaMascotasRaiting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiting);



        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        miActionBar.setLogo(R.drawable.dog_paw);
        setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotasRaiting = (RecyclerView) findViewById(R.id.rvContactos2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasRaiting.setLayoutManager(llm);
        InicializarListaRaitings();
        InicializarAdaptador2();



    }


    public void InicializarAdaptador2(){
        Adaptador adaptador = new Adaptador(contactos2, RaitingActivity.this);
        listaMascotasRaiting.setAdapter(adaptador);
    }
    public void InicializarListaRaitings(){

        contactos2 = new ArrayList<Contacto>();
        contactos2.add(new Contacto(R.drawable.cat1,"Félix","8",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos2.add(new Contacto(R.drawable.dog1,"Arwen","2",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos2.add(new Contacto(R.drawable.cat3,"Anubis","2",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos2.add(new Contacto(R.drawable.cat4,"Tiger","6",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos2.add(new Contacto(R.drawable.dog4,"Dafnis","9",R.drawable.dog_bone,R.drawable.dog_bone_yellow));

    }
    //Sirve para optimizar las apps usando una actividad a la vez
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){

            Intent intent = new Intent(RaitingActivity.this,MainActivity.class);
            finish();
            startActivity(intent);

        }

        return super.onKeyDown(keyCode, event);
    }
}