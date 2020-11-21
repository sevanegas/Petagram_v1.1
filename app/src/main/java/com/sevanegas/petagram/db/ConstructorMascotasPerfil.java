package com.sevanegas.petagram.db;

import android.content.Context;

import com.sevanegas.petagram.R;
import com.sevanegas.petagram.pojo.Datos_Mascota_Grind;

import java.util.ArrayList;

public class ConstructorMascotasPerfil {
    private Context context;
    public ConstructorMascotasPerfil(Context context){
        this.context = context;
    }

    public ArrayList<Datos_Mascota_Grind> obtenerdatosPerfil(){
        ArrayList<Datos_Mascota_Grind>  mas = new ArrayList<>();
        mas.add(new Datos_Mascota_Grind(R.drawable.perro_10,"50",R.drawable.hueso_a));
        mas.add(new Datos_Mascota_Grind(R.drawable.perro_10,"20",R.drawable.hueso_a));
        mas.add(new Datos_Mascota_Grind(R.drawable.perro_10,"12",R.drawable.hueso_a));
        mas.add(new Datos_Mascota_Grind(R.drawable.perro_10,"100",R.drawable.hueso_a));
        mas.add(new Datos_Mascota_Grind(R.drawable.perro_10,"250",R.drawable.hueso_a));
        mas.add(new Datos_Mascota_Grind(R.drawable.perro_10,"3",R.drawable.hueso_a));
        mas.add(new Datos_Mascota_Grind(R.drawable.perro_10,"78",R.drawable.hueso_a));
        mas.add(new Datos_Mascota_Grind(R.drawable.perro_10,"96",R.drawable.hueso_a));
        mas.add(new Datos_Mascota_Grind(R.drawable.perro_10,"500",R.drawable.hueso_a));
        mas.add(new Datos_Mascota_Grind(R.drawable.perro_10,"10",R.drawable.hueso_a));
        mas.add(new Datos_Mascota_Grind(R.drawable.perro_10,"56",R.drawable.hueso_a));
        mas.add(new Datos_Mascota_Grind(R.drawable.perro_10,"37",R.drawable.hueso_a));

        return mas;
    }
}
