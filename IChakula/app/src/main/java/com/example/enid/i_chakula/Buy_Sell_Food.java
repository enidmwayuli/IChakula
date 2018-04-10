package com.example.enid.i_chakula;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Buy_Sell_Food extends AppCompatActivity {

    ImageButton imageButton2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy__sell__food);

        imageButton2 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                Toast.makeText(Buy_Sell_Food.this, "1000 kg of beans available at ksh300 per kg ", Toast.LENGTH_LONG).show();
            }
                                        }

        );


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
