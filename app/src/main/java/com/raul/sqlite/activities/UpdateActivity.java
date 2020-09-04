package com.raul.sqlite.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raul.sqlite.Data;
import com.raul.sqlite.POJOS.Usuario;
import com.raul.sqlite.R;
import com.raul.sqlite.SQLconstants;

public class UpdateActivity extends AppCompatActivity {

    EditText id_update, nombre_update,edad_update,correo_update;
    Button button_buscar, button_actualizar;
    Data data;

    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        data = new Data(getApplicationContext());
        data.open();

        id_update = findViewById(R.id.id_update);
        nombre_update = findViewById(R.id.update_nombre);
        edad_update = findViewById(R.id.update_edad);
        correo_update = findViewById(R.id.update_correo);

        button_buscar = findViewById(R.id.search_usuario_button);
        button_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuario = new Usuario();

                String idSearch = id_update.getText().toString();

                usuario = data.getUsuario(idSearch);

                nombre_update.setText(usuario.getNombre());
                edad_update.setText(String.valueOf(usuario.getEdad()));
                correo_update.setText(usuario.getCorreo());

                //data.close();
            }
        });

        button_actualizar = findViewById(R.id.update_button);
        button_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = id_update.getText().toString();

                ContentValues contentValues = new ContentValues(4);

                contentValues.put(SQLconstants.COLUMN_NOMBRE,nombre_update.getText().toString());
                contentValues.put(SQLconstants.COLUMN_EDAD, Integer.valueOf(edad_update.getText().toString()));
                contentValues.put(SQLconstants.COLUMN_CORREO,correo_update.getText().toString());

                data.UpdateUser(id,contentValues);

                Toast.makeText(getApplicationContext(),"Se actualizo el usuario", Toast.LENGTH_SHORT).show();
            }
        });
    }
}