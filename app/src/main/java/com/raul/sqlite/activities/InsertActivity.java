package com.raul.sqlite.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raul.sqlite.Data;
import com.raul.sqlite.POJOS.Usuario;
import com.raul.sqlite.R;

public class InsertActivity extends AppCompatActivity {

    EditText id,nombre,edad,correo;
    Button insert_button;

    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        id = findViewById(R.id.id);
        nombre = findViewById(R.id.nombre);
        edad = findViewById(R.id.edad);
        correo = findViewById(R.id.correo);

        insert_button = findViewById(R.id.button_insert);

        insert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Usuario usuario = new Usuario(
                         id.getText().toString(),
                         nombre.getText().toString(),
                         Integer.valueOf(edad.getText().toString()),
                         correo.getText().toString()

                 );
                data  = new Data(getApplicationContext());
                data.open();
                data.insertUsuario(usuario);
                Toast.makeText(getApplicationContext(),"Se agrego el usuario", Toast.LENGTH_LONG).show();
                data.close();
            }
        });
    }
}