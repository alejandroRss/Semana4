package com.farussif.semana3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.farussif.semana3.R;
import com.farussif.semana3.adapter.Adaptador;
import com.farussif.semana3.pojo.Contacto;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Contacto> contactos;
    private RecyclerView listaImagenes;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v1 = inflater.inflate(R.layout.fragment_perfil, container,false); //Equivale al setContentView de la clase Main

        listaImagenes = (RecyclerView) v1.findViewById(R.id.rvFavoritos);


        GridLayoutManager glm = new GridLayoutManager(getContext(),2);

        listaImagenes.setLayoutManager(glm);
        InicializarListaPerfiles();
        InicializarAdaptador();


        return v1;
    }
    public void InicializarAdaptador(){
        Adaptador adaptador = new Adaptador(contactos, getActivity());
        listaImagenes.setAdapter(adaptador);
    }
    public void InicializarListaPerfiles(){

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.dog_fav1,"8",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.dog_fav2,"2",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.dog_fav3,"4",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.dog_fav4,"1",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.dog_fav5,"2",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.dog_fav6,"11",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.dog_fav7,"6",R.drawable.dog_bone,R.drawable.dog_bone_yellow));
        contactos.add(new Contacto(R.drawable.dog_fav8,"9",R.drawable.dog_bone,R.drawable.dog_bone_yellow));

    }
}