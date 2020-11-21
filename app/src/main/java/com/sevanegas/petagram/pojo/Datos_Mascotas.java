package com.sevanegas.petagram.pojo;

public class Datos_Mascotas {

    private int Id;
    private String nombre_mascota;
    private int foto;
    private int fotofav;
    private int like = 0;

    public Datos_Mascotas(String nombre_mascota, int foto, int fotofav, int like) {
        this.nombre_mascota = nombre_mascota;
        this.foto = foto;
        this.fotofav = fotofav;
        this.like = like;
    }

    public Datos_Mascotas() {

    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getFotofav() {
        return fotofav;
    }

    public void setFotofav(int fotofav) {
        this.fotofav = fotofav;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
