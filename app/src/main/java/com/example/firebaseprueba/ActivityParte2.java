package com.example.firebaseprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityParte2 extends AppCompatActivity {

    ListView lvJugador;

    ArrayList<CJugador> lista_jugadores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte2);

        cargarDatos();

        lvJugador=(ListView)findViewById(R.id.lvJugadores);

        AdaptadorJugador adaptadorJugador = new AdaptadorJugador(this, lista_jugadores);
        lvJugador.setAdapter(adaptadorJugador);
        lvJugador.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CJugador c =((CJugador)parent.getItemAtPosition(position));
                Double sueldo = c.getSueldo();
                Toast.makeText(getApplicationContext(), "Sueldo: "+sueldo,Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void cargarDatos(){
        lista_jugadores.add(new CJugador("Messi", 11, "Delantero", 50000));
        lista_jugadores.add(new CJugador("Piqué", 13, "Defensa", 40000));
        lista_jugadores.add(new CJugador("Iniesta", 8, "Mediocentro", 30000));
        lista_jugadores.add(new CJugador("Ter Stegen", 1, "Portero", 20000));
    }
}
