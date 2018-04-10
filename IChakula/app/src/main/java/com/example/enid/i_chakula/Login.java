package com.example.enid.i_chakula;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private Button buttonLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignUp;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser()!=null){
            //Guidelines Activity
            finish();
            startActivity(new Intent(getApplicationContext(), Guidelines.class));
        }

        progressDialog= new ProgressDialog(this);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignUp = (TextView) findViewById(R.id.textViewSignUp);

        buttonLogin.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);


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

    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //Email is empty
            Toast.makeText(Login.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            //Stops the function from executing any further
            return;
        }
        if (TextUtils.isEmpty(password)) {
            //Email is empty

            Toast.makeText(Login.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            //Stops the function from executing any further
            return;
        }
        //Show progress bar is registration is successfull


        progressDialog.setMessage("Login in progress...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
            @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    //start guidelines activity
                    finish();
                    startActivity(new Intent(getApplicationContext(), Guidelines.class));
                }
            }


        });
    }

    @Override
    public void onClick(View view) {

        if (view == buttonLogin)
        {
            userLogin();
        }
        if (view == textViewSignUp)
        {
            //Will Open Login Activity
            finish();
            startActivity(new Intent(this, SignUp.class));
        }

        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
