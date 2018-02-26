package com.example.firebaseprueba;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnparte1 (View view){
        Intent i =new Intent(getApplicationContext(),ActivityParte1.class);
        startActivity(i);
    }

    public void btnEjercicioparte1 (View view){
        Intent i = new Intent(getApplicationContext(),ActivityEjercicioParte1.class);
        startActivity(i);
    }

    public void btnparte2 (View view){
        Intent i = new Intent(getApplicationContext(), ActivityParte2.class);
        startActivity(i);
    }

    public void btnparte3 (View view){
        Intent i = new Intent(getApplicationContext(), ActivityParte3.class);
        startActivity(i);
    }

}
