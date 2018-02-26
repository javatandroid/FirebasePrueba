package com.example.firebaseprueba;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DIDACT on 26/02/2018.
 */

public class AdaptadorJugador extends ArrayAdapter<CJugador> {

    ArrayList<CJugador> jugadores;
    Context c;

    public AdaptadorJugador(Context c, ArrayList<CJugador> jugadores){
        super(c,R.layout.item_jugador, jugadores);
        this.c = c;
        this.jugadores = jugadores;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_jugador,null);

        //TextView Nombre
        TextView tvnombre=(TextView)item.findViewById(R.id.tvNombreJugador);
        tvnombre.setText(jugadores.get(position).getNombre());

        //TextView Dorsal
        TextView tvdorsal=(TextView)item.findViewById(R.id.tvDorsalJugador);
        tvdorsal.setText(""+jugadores.get(position).getDorsal());

        //TextView Posición
        TextView tvposicion=(TextView)item.findViewById(R.id.tvPosicionJugador);
        tvposicion.setText(jugadores.get(position).getPosicion());

               return item;
    }

}
