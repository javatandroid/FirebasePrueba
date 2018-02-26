package com.example.firebaseprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ActivityParte2 extends AppCompatActivity {

    ListView lvJugador;

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    ArrayList<CJugador> lista_jugadores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte2);

        cargarDatosFirebase();

        lvJugador=(ListView)findViewById(R.id.lvJugadores);

    }

    private void cargarDatosFirebase(){
        //Conexión con la base de datos
        dbRef = FirebaseDatabase.getInstance().getReference().child("jugadores"); //Nombre referente a la clase añadida en Firebase
        //Añadimos el evento que nos devolverá los valores
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lista_jugadores.clear();
                for (DataSnapshot jugadoresDataSnapshot: dataSnapshot.getChildren()) {
                    cargarListView(jugadoresDataSnapshot);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ActivityParte2", "DATABASE ERROR");
            }
        };
        dbRef.addValueEventListener(valueEventListener); //Para cargar datos en tiempo real
    }

    private void cargarListView (DataSnapshot dataSnapshot){

        lista_jugadores.add(dataSnapshot.getValue(CJugador.class));

        AdaptadorJugador adaptadorJugador = new AdaptadorJugador(this, lista_jugadores);
        lvJugador.setAdapter(adaptadorJugador);

        lvJugador.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CJugador c =((CJugador)parent.getItemAtPosition(position));
                Toast.makeText(getApplicationContext(), "Sueldo: "+c.getSueldo(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
