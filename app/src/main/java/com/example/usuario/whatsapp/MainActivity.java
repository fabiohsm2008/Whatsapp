package com.example.usuario.whatsapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper db = new DBHelper(this);
        List<ItemsContactos> contactos = new ArrayList<>();
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setScaleX(0);
        fab.setScaleY(0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            final Interpolator interpolador = AnimationUtils.loadInterpolator(getBaseContext(),
                    android.R.interpolator.bounce);
            fab.animate()
                    .scaleX(1)
                    .scaleY(1)
                    .setInterpolator(interpolador)
                    .setDuration(600)
                    .setStartDelay(1000);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Agregar_Contacto.class);
                startActivity(i);
            }
        });
        Cursor c  = db.getTodosContactos();
        while (c.moveToNext()){
            String nombre = c.getString(c.getColumnIndex("nombre"));
            String apellido = c.getString(c.getColumnIndex("apellido"));
            String fullname = nombre +" "+apellido;
            contactos.add(new ItemsContactos(Integer.parseInt(c.getString(c.getColumnIndex("id"))),fullname));
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listaContactos);
        RecyclerViewContactos adapter = new RecyclerViewContactos(contactos,getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
