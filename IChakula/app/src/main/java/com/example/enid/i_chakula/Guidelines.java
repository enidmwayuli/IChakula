package com.example.enid.i_chakula;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Guidelines extends AppCompatActivity implements View.OnClickListener{

    //private FirebaseAuth firebaseAuth;
   // private TextView textViewUserEmail;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidelines);

        button = (Button) findViewById(R.id.nextButton1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                 openDonate_foods();
             }

        });


        //firebaseAuth = FirebaseAuth.getInstance();
        //if (firebaseAuth.getCurrentUser()!=null){
            //Guidelines Activity
            //finish();
            //startActivity(new Intent(getApplicationContext(), Login.class));
        //}

        //FirebaseUser user = firebaseAuth.getCurrentUser();

        //textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        //textViewUserEmail.setText("Welcome "+user.getEmail());
        //buttonLogout = (Button) findViewById(R.id.buttonLogout);
        //buttonLogout.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                      //  .setAction("Action", null).show();
            //}
        }
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    public void openDonate_foods(){

        Intent intent = new Intent(this, Donate_food.this);
        startActivity(intent);
    }
}
