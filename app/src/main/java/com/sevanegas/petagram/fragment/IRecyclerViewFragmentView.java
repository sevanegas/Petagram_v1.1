package com.sevanegas.petagram.fragment;

import com.sevanegas.petagram.adapter.MascotaAdaptador;
import com.sevanegas.petagram.pojo.Datos_Mascotas;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {
    public void generarLinerLayoutVertical();
    public MascotaAdaptador crearAdaptador (ArrayList <Datos_Mascotas> mascotas);
    public void inicializarAdaptadorRV (MascotaAdaptador adaptador);
}
