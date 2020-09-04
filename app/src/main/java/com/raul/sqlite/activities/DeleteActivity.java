package com.raul.sqlite.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raul.sqlite.Data;
import com.raul.sqlite.R;

public class DeleteActivity extends AppCompatActivity {

    EditText id_delete;
    Button delete;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        id_delete = findViewById(R.id.Id_delete);
        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = id_delete.getText().toString();
                data = new Data(getApplicationContext());
                data.deleteUser(id);
                Toast.makeText(getApplicationContext(),"Se ha eliminado el usuario ", Toast.LENGTH_LONG).show();
            }
        });
    }
}