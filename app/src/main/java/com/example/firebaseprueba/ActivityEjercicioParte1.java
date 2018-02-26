package com.example.firebaseprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityEjercicioParte1 extends AppCompatActivity {

    TextView tvnombre, tvdorsal, tvposicion, tvsueldo;
    Spinner spjugador;
    private DatabaseReference dbRef;
    private ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_parte1);

        tvnombre = (TextView) findViewById(R.id.tvFormNombre);
        tvdorsal = (TextView) findViewById(R.id.tvFormDorsal);
        tvposicion = (TextView) findViewById(R.id.tvFormPosicion);
        tvsueldo = (TextView) findViewById(R.id.tvFormSueldo);

        spjugador=(Spinner)findViewById(R.id.spJugador);
        String[] jugadores={"j1","j2","j3","j4"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,jugadores);
        spjugador.setAdapter(adaptador);
    }

    public void ibjugador (View view){
        String jugadorSeleccionado = spjugador.getSelectedItem().toString();

        dbRef = FirebaseDatabase.getInstance().getReference().child("jugadores/"+ jugadorSeleccionado);

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                CJugador jug = dataSnapshot.getValue(CJugador.class);
                tvnombre.setText("Nombre: " + jug.getNombre());
                tvdorsal.setText("Dorsal: " +jug.getDorsal()+"");
                tvposicion.setText("Posición: " +jug.getPosicion());
                tvsueldo.setText("Sueldo: " +jug.getSueldo()+"");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ActivityEjercicioParte1", "DATABASE ERROR");

            }
        };
        dbRef.addValueEventListener(valueEventListener);

    }
}
