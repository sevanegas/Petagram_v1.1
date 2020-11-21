package com.sevanegas.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sevanegas.petagram.adapter.MascotaAdaptador;
import com.sevanegas.petagram.fragment.IRecyclerViewFragmentView;
import com.sevanegas.petagram.pojo.Datos_Mascotas;
import com.sevanegas.petagram.presenter.FavoritoPresenter;

import java.util.ArrayList;

public class Favorito extends AppCompatActivity  implements IRecyclerViewFragmentView{

    ArrayList<Datos_Mascotas> mas;
    private RecyclerView LisMascotas;
    private FavoritoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        Toolbar ActionBar = findViewById(R.id.actionbar);
        setSupportActionBar(ActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        LisMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        presenter = new FavoritoPresenter(this, this);


    }


    @Override
    public void generarLinerLayoutVertical() {

        LinearLayoutManager llam = new LinearLayoutManager(this);
        llam.setOrientation(LinearLayoutManager.VERTICAL);

        LisMascotas.setLayoutManager(llam);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Datos_Mascotas> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        LisMascotas.setAdapter(adaptador);

    }
}