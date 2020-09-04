package com.raul.sqlite.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.raul.sqlite.Data;
import com.raul.sqlite.POJOS.Usuario;
import com.raul.sqlite.R;

public class SearchActivity extends AppCompatActivity {

    EditText id;
    Button search_button;
    Data data;

    Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        usuario = new Usuario();
        id = findViewById(R.id.id);
        search_button = findViewById(R.id.search);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idSearch = id.getText().toString();
                data = new Data(getApplicationContext());
                data.open();
                usuario = data.getUsuario(idSearch);

                Log.e("RESULTADO: ", usuario.getNombre());
            }
        });
    }
}