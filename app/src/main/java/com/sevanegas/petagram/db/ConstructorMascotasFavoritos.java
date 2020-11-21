package com.sevanegas.petagram.db;

import android.content.Context;

import com.sevanegas.petagram.pojo.Datos_Mascotas;

import java.util.ArrayList;

public class ConstructorMascotasFavoritos {

    private Context  context;
    ArrayList<Datos_Mascotas> mascotas = new ArrayList<>();

    public ConstructorMascotasFavoritos(Context context) {
        this.context = context;
    }

    public ArrayList<Datos_Mascotas> obtenerDatos() {

        int valor;
        int valorA = 1000000;
        int posicion = 0;
        int j;
        ArrayList<Integer> Likes = new ArrayList<>();
        ArrayList<Datos_Mascotas> mascotasfav = new ArrayList<>();
        BaseDatos db = new BaseDatos(context);
        mascotas = db.obetenerTodosLosContactos();
        for(int i = 0; i < mascotas.size(); i++){
            Likes.add(obtenerLikeMascota(mascotas.get(i)));
        }
        for(int i = 0; i < 5; i++){
            valor = 0;
            j = 0;
            posicion = 0;
            while (j < Likes.size()){
                if(valor < Likes.get(j) && Likes.get(j) < valorA){
                    valor = Likes.get(j);
                    posicion = j;
                }
                j++;
            }
            valorA = valor;
            mascotasfav.add(i, mascotas.get(posicion));
        }
        db.close();
        return mascotasfav;
    }
    public int obtenerLikeMascota(Datos_Mascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikeMascota(mascotas);
    }


}
