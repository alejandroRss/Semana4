package com.farussif.semana3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.farussif.semana3.adapter.PageAdapter;
import com.farussif.semana3.fragment.PerfilFragment;
import com.farussif.semana3.fragment.RecyclerViewFragment;
import com.farussif.semana3.pojo.Contacto;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaMascotas;
    private androidx.appcompat.widget.Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        miActionBar.setLogo(R.drawable.dog_paw);
        setTitle("");

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.Toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.ViewPager) ;
        setUpViewPager();



        }
    private void setUpViewPager(){
        //pasa soporte del FragmentManager y pasa los Fragments
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pet);

    }
    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(this,Contacto_Activity.class);
                startActivity(intent);
                break;
            case R.id.mAcercaDe:
                Intent intent2 = new Intent(this,AcercaDeActivity.class);
                startActivity(intent2);
                break;


        }

        return super.onOptionsItemSelected(item);
    }





    public void Raiting(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,RaitingActivity.class);


        startActivity(intent);
    }
}