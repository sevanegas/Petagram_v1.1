package com.sevanegas.petagram.presenter;

import android.content.Context;


import com.sevanegas.petagram.db.ConstructorMascotas;
import com.sevanegas.petagram.fragment.IRecyclerViewFragmentView;
import com.sevanegas.petagram.pojo.Datos_Mascotas;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter  implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList <Datos_Mascotas> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();

    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarContactosRV();

    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinerLayoutVertical();

    }
}
