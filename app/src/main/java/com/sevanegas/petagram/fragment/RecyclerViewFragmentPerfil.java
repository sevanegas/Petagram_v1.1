package com.sevanegas.petagram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sevanegas.petagram.adapter.MascotaAdaptador;
import com.sevanegas.petagram.adapter.MascotaAdaptadorGrind;
import com.sevanegas.petagram.R;
import com.sevanegas.petagram.pojo.Datos_Mascota_Grind;
import com.sevanegas.petagram.presenter.IRecyclerViewFragmentPerfilPresenter;
import com.sevanegas.petagram.presenter.RecyclerViewFragmentPerfilPresenter;



import java.util.ArrayList;

public class RecyclerViewFragmentPerfil extends Fragment implements IRecyclerViewFragmentPerfilView {

    ArrayList<Datos_Mascota_Grind> mas;
    private RecyclerView ListaMas;
    private IRecyclerViewFragmentPerfilPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recyclerview_perfil, container, false);

        ListaMas = (RecyclerView) v.findViewById(R.id.rvMascotasFrag);
        presenter = new RecyclerViewFragmentPerfilPresenter(this,getContext());

        return v;
    }




    @Override
    public void generarLinerLayoutVerticalPerfil() {

        ListaMas.setLayoutManager(new GridLayoutManager(getContext(),3 ));

    }

    @Override
    public MascotaAdaptadorGrind crearAdaptadorPerfil(ArrayList<Datos_Mascota_Grind> mas) {
        MascotaAdaptadorGrind adaptador = new MascotaAdaptadorGrind(mas);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorPerfilRV(MascotaAdaptadorGrind adaptador) {
        ListaMas.setAdapter(adaptador);

    }

}

