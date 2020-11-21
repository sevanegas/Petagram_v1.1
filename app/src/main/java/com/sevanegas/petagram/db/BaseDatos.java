package com.sevanegas.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.sevanegas.petagram.pojo.Datos_Mascotas;

import java.util.ArrayList;

public class BaseDatos  extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos( Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContactoMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_CONTACTS + "(" +
                                                ConstantesBaseDatos.TABLE_CONTACTS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT , "  +
                                                ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE   + " TEXT ,"    +
                                                ConstantesBaseDatos.TABLE_CONTACTS_FOTO     + " INTEGER ," +
                                                ConstantesBaseDatos.TABLE_CONTACTS_FOTOFAV  + " INTEGER " +
                                                ")";

        String queryCrearTablaLikeContactoMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_CONTACTS+ "(" +
                                                    ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                                                    ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO + " INTEGER ," +
                                                    ConstantesBaseDatos.TABLE_LIKES_CONTACTS_NUMERO_LIKE + " INTEGER  ," +
                                                    "FOREIGN KEY ("+ ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO +") " +
                                                    "REFERENCES " + ConstantesBaseDatos.TABLE_CONTACTS + "("+ConstantesBaseDatos.TABLE_CONTACTS_ID+")" +
                                                    ")";
        db.execSQL(queryCrearTablaContactoMascota);
        db.execSQL(queryCrearTablaLikeContactoMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_CONTACTS);
        onCreate(db);
    }


    public ArrayList<Datos_Mascotas> obetenerTodosLosContactos(){
        ArrayList<Datos_Mascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Datos_Mascotas contactoActual = new Datos_Mascotas();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre_mascota(registros.getString(1));
            contactoActual.setFoto(registros.getInt(2));
            contactoActual.setFotofav(registros.getInt(3));

            String queryLikes = "SELECT COUNT ("+ ConstantesBaseDatos.TABLE_LIKES_CONTACTS_NUMERO_LIKE+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACTS +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO + "=" +  contactoActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()) {
                contactoActual.setLike(registrosLikes.getInt(0));
            }else{
                contactoActual.setLike(0);
            }

              mascotas.add(contactoActual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascotas (ContentValues contentValues){
        SQLiteDatabase db =  this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_CONTACTS, null, contentValues );
        db.close();
    }

    public void insertarLikeMascotas (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_CONTACTS,null,contentValues);
        db.close();
    }

    public int obtenerLikeMascota(Datos_Mascotas mascotas){
        int like = 0;

        String query = "SELECT COUNT ("+ ConstantesBaseDatos.TABLE_LIKES_CONTACTS_NUMERO_LIKE+")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACTS +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO + "=" + mascotas.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){

            like = registros.getInt(0);
        }

        db.close();

        return like;
    }
}
