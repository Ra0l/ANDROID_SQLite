package com.raul.sqlite.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.raul.sqlite.R;

public class MainActivity extends AppCompatActivity {

    Button button_insert, search_button, button_delete, button_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_insert = findViewById(R.id.insert);
        search_button = findViewById(R.id.search_activity);

        button_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),InsertActivity.class);
                startActivity(intent);
            }
        });

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(intent);
            }
        });

        button_delete = findViewById(R.id.delete_activity);
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DeleteActivity.class);
                startActivity(intent);
            }
        });

        button_update = findViewById(R.id.button_update);
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),UpdateActivity.class);
                startActivity(intent);
            }
        });


    }
}