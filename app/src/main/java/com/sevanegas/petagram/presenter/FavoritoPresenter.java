package com.sevanegas.petagram.presenter;

import android.content.Context;

import com.sevanegas.petagram.db.ConstructorMascotas;
import com.sevanegas.petagram.db.ConstructorMascotasFavoritos;
import com.sevanegas.petagram.fragment.IRecyclerViewFragmentView;
import com.sevanegas.petagram.pojo.Datos_Mascotas;

import java.util.ArrayList;

public class FavoritoPresenter implements IFavoritoPresenter{


    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotasFavoritos constructorMascotasFavoritos;
    private ArrayList<Datos_Mascotas> mascotas;

    public FavoritoPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatosFavoritos();

    }



    @Override
    public void obtenerMascotasBaseDatosFavoritos() {
        constructorMascotasFavoritos = new ConstructorMascotasFavoritos(context);
        mascotas = null;
        mascotas =constructorMascotasFavoritos.obtenerDatos();
        mostrarContactosFavoritosRV();



    }

    @Override
    public void mostrarContactosFavoritosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinerLayoutVertical();

    }
}
