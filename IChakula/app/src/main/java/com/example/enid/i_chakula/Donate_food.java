package com.example.enid.i_chakula;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Donate_food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_food);

        Spinner locationSpinner = (Spinner)findViewById(R.id.spinner1);
        Spinner categorySpinner = (Spinner)findViewById(R.id.spinner2);
        Spinner ngoSpinner = (Spinner)findViewById(R.id.spinner3);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Donate_food.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Location));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(myAdapter);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(Donate_food.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Category));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(myAdapter1);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(Donate_food.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Ngo));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ngoSpinner.setAdapter(myAdapter2);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
