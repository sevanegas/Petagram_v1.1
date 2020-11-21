package com.sevanegas.petagram.presenter;

import android.content.Context;


import com.sevanegas.petagram.db.ConstructorMascotasPerfil;
import com.sevanegas.petagram.fragment.IRecyclerViewFragmentPerfilView;
import com.sevanegas.petagram.fragment.IRecyclerViewFragmentView;
import com.sevanegas.petagram.pojo.Datos_Mascota_Grind;


import java.util.ArrayList;

public class RecyclerViewFragmentPerfilPresenter implements IRecyclerViewFragmentPerfilPresenter {

    private IRecyclerViewFragmentPerfilView iRecyclerViewFragmentPerfilView;
    private Context context;
    private ConstructorMascotasPerfil constructorMascotasPerfil;
    private ArrayList<Datos_Mascota_Grind> mas;

    public RecyclerViewFragmentPerfilPresenter(IRecyclerViewFragmentPerfilView iRecyclerViewFragmentPerfilView, Context context){
        this.iRecyclerViewFragmentPerfilView = iRecyclerViewFragmentPerfilView;
        this.context = context;
        obtenerMascotasBaseDatosPerfil();

    }


    @Override
    public void obtenerMascotasBaseDatosPerfil() {
        constructorMascotasPerfil = new ConstructorMascotasPerfil(context);
        mas = constructorMascotasPerfil.obtenerdatosPerfil();
        mostrarContactosPerfilRV();

    }

    @Override
    public void mostrarContactosPerfilRV() {
        iRecyclerViewFragmentPerfilView.inicializarAdaptadorPerfilRV(iRecyclerViewFragmentPerfilView.crearAdaptadorPerfil(mas));
        iRecyclerViewFragmentPerfilView.generarLinerLayoutVerticalPerfil();


    }
}
