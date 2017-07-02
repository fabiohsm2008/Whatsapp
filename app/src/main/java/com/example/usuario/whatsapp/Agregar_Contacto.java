package com.example.usuario.whatsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Agregar_Contacto extends AppCompatActivity {
    EditText nombre;
    EditText apellido;
    EditText correo;
    Button editar;
    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);
        final DBHelper db = new DBHelper(this);
        nombre = (EditText)findViewById(R.id.input_nombre);
        apellido = (EditText) findViewById(R.id.input_apellido);
        correo = (EditText) findViewById(R.id.input_correo);
        editar = (Button) findViewById(R.id.btn_Editar);
        regresar = (Button)findViewById(R.id.button1);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertarContacto(nombre.getText().toString(),apellido.getText().toString(),correo.getText().toString());
                Toast.makeText(Agregar_Contacto.this,"Contacto Insertado",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
