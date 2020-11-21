package com.sevanegas.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.sevanegas.petagram.R;
import com.sevanegas.petagram.pojo.Datos_Mascotas;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Datos_Mascotas> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        insertarDiesMascotas(db);
        return db.obetenerTodosLosContactos();
    }

    public void insertarDiesMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"Kira" );
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.perro_2);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTOFAV, R.drawable.hueso_a);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"Dominic" );
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.perro_3);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTOFAV, R.drawable.hueso_a);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"Dante" );
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.perro_4);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTOFAV, R.drawable.hueso_a);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"Lucas" );
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.perro_5);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTOFAV, R.drawable.hueso_a);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"Maya" );
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.perro_9);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTOFAV, R.drawable.hueso_a);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"Tarcan" );
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.perro_10   );
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTOFAV, R.drawable.hueso_a);

        db.insertarMascotas(contentValues);









    }

    public void darLikeMascota(Datos_Mascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO, mascotas.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACTS_NUMERO_LIKE, LIKE);
        db.insertarLikeMascotas(contentValues);

    }

    public int obtenerLikeMascota(Datos_Mascotas mascotas){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikeMascota(mascotas);

    }


}
