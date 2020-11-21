package com.sevanegas.petagram.db;

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "contactos_mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_CONTACTS           = "contacto";
    public static final String TABLE_CONTACTS_ID        = "id";
    public static final String TABLE_CONTACTS_NOMBRE    = "Nombre";
    public static final String TABLE_CONTACTS_FOTO      = "foto";
    public static final String TABLE_CONTACTS_FOTOFAV   = "fotofav";

    public static final String TABLE_LIKES_CONTACTS                 = "contacto_like";
    public static final String TABLE_LIKES_CONTACTS_ID              = "id";
    public static final String TABLE_LIKES_CONTACTS_ID_CONTACTO     = "id_contacto";
    public static final String TABLE_LIKES_CONTACTS_NUMERO_LIKE     = "numero_likes";
}
