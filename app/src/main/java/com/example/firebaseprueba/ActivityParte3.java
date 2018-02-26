package com.example.firebaseprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityParte3 extends AppCompatActivity {

    EditText etNombre, etDorsal, etPosicion, etSueldo;
    Spinner spJugadores;

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte3);

        etNombre=(EditText)findViewById(R.id.etNombreParte3);
        etDorsal=(EditText)findViewById(R.id.etDorsalParte3);
        etPosicion=(EditText)findViewById(R.id.etPosicionParte3);
        etSueldo=(EditText)findViewById(R.id.etSueldoParte3);

        spJugadores=(Spinner)findViewById(R.id.spParte3);
        String[] jugadoresspinner={"j1","j2","j3","j4","j5","j6"};
        ArrayAdapter<String> adaptadorJugadores = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,jugadoresspinner);
        spJugadores.setAdapter(adaptadorJugadores);
    }

    public void btnLupaParte3 (View view) {
        String jugadorspinner = spJugadores.getSelectedItem().toString();

        dbRef = FirebaseDatabase.getInstance().getReference().child("jugadoresspinner/" + jugadorspinner); // Se añade / para especificar uno en concreto. Si no, nada
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                CJugador jug = dataSnapshot.getValue(CJugador.class);
                etNombre.setText("Nombre: " + jug.getNombre());
                etDorsal.setText("Dorsal: " + jug.getDorsal()+"");
                etPosicion.setText("Posición: " + jug.getPosicion());
                etSueldo.setText("Sueldo: " + jug.getSueldo()+"");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Activityparte3", "DATABASE ERROR");
            }
        };
        dbRef.addValueEventListener(valueEventListener);
    }

    public void btnGuardarParte3 (View view){
        String nombrejug = etNombre.getText().toString();
        String dorsaljug = etDorsal.getText().toString();
        String posicionjug = etPosicion.getText().toString();
        String sueldojug = etSueldo.getText().toString();

        if(nombrejug.equals("")||dorsaljug.equals("")||posicionjug.equals("")sueldojug.equals("")){
            Toast.makeText(getApplicationContext(), "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            double sueldo = Double.parseDouble(sueldojug);
            CJugador nuevoJugador = new CJugador(nombrejug, dorsaljug, posicionjug, sueldojug);
            dbRef= FirebaseDatabase.getInstance().getReference().child("jugadores");

            //String nueva_clave=dbRef.push().setValue(nuevoJugador, new Database
        }
    }

    public void btnModificarParte3 (View view){

    }

    public void btnEliminarParte3 (View view){

    }

    }

