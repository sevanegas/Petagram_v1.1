package com.sevanegas.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.sevanegas.petagram.db.ConstructorMascotas;
import com.sevanegas.petagram.pojo.Datos_Mascotas;
import com.sevanegas.petagram.R;

import java.util.ArrayList;

public class MascotaAdaptador  extends RecyclerView.Adapter <MascotaAdaptador.MascotasViewHolder>{

    ArrayList<Datos_Mascotas> mascotas;
    Activity activity;



    public MascotaAdaptador (ArrayList<Datos_Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    public MascotaAdaptador(ArrayList<Datos_Mascotas> mascotas){
        this.mascotas = mascotas;
    }




    @Override
    public MascotasViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotasViewHolder mascotasViewHolder, int position) {
        final Datos_Mascotas mascota = mascotas.get(position);
        mascotasViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotasViewHolder.tvNombre.setText(mascota.getNombre_mascota());
        mascotasViewHolder.imgFavorito.setImageResource(mascota.getFotofav());
        mascotasViewHolder.tvCont.setText(String.valueOf(mascota.getLike()));
        mascotasViewHolder.btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Like a " + mascota.getNombre_mascota(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotasViewHolder.tvCont.setText(String.valueOf(constructorMascotas.obtenerLikeMascota(mascota)));


            }
        });




    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private ImageButton btLike;
        private TextView tvNombre;
        private TextView tvCont;
        private ImageView imgFavorito;

         public MascotasViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            btLike = (ImageButton) itemView.findViewById(R.id.btLike);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCont = (TextView) itemView.findViewById(R.id.tvCont);
            imgFavorito = (ImageView) itemView.findViewById(R.id.imgFavorito);

        }
    }

}
