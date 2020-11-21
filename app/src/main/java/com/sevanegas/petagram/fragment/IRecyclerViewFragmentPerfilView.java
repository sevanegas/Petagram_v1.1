package com.sevanegas.petagram.fragment;


import com.sevanegas.petagram.adapter.MascotaAdaptadorGrind;
import com.sevanegas.petagram.pojo.Datos_Mascota_Grind;


import java.util.ArrayList;

public interface IRecyclerViewFragmentPerfilView {

    public void generarLinerLayoutVerticalPerfil();
    public MascotaAdaptadorGrind crearAdaptadorPerfil (ArrayList<Datos_Mascota_Grind> mas);
    public void inicializarAdaptadorPerfilRV (MascotaAdaptadorGrind adaptador);
}
