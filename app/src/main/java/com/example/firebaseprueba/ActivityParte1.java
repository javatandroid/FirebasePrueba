package com.example.firebaseprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class ActivityParte1 extends AppCompatActivity {

    TextView tvJugador;
    //Variables objetos FIREBASE
    private DatabaseReference dbRef;
    private ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte1);

        tvJugador = (TextView) findViewById(R.id.tvJugador);

        dbRef = FirebaseDatabase.getInstance().getReference().child("jugadores/j1");

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                CJugador jug = dataSnapshot.getValue(CJugador.class);
                tvJugador.setText("Nombre " + jug.getNombre() + "\n +" +
                        "Dorsal " + jug.getDorsal() + "\n +" +
                        "Posicion " + jug.getPosicion() + "\n +" +
                        "Sueldo " + jug.getSueldo());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ActivityParte1", "DATABASE ERROR");

            }
        };
        dbRef.addValueEventListener(valueEventListener);//Para base de datos en tiempo real
        //dbRef.addListenerForSingleValueEvent(valueEventListener); //Para base de datos de una sola carga
        //dbRef.removeEventListener(valueEventListener); //Destruye la conexión a tiempo real entre el listener y la base de datos
    }
}
