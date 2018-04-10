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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public abstract class SignUp extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="EmailPassword";
    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewLogin;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser()!=null){
            //Guidelines Activity
            finish();
            startActivity(new Intent(getApplicationContext(), Guidelines.class));
        }

        progressDialog= new ProgressDialog(this);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewLogin = (TextView) findViewById(R.id.textViewLogin);

        buttonRegister.setOnClickListener(this);
        textViewLogin.setOnClickListener(this);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {


            private void registerUser() {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    //Email is empty
                    Toast.makeText(SignUp.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    //Stops the function from executing any further
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    //Email is empty

                    Toast.makeText(SignUp.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    //Stops the function from executing any further
                    return;
                }
                //Show progress bar is registration is successful


                progressDialog.setMessage("Registering User...");
                progressDialog.show();

                //creating a new user
                firebaseAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    finish();
                                    startActivity(new Intent(getApplicationContext(), GuidelinesActivities.class));




                                    // Sign in success, update UI with the signed-in user's information
                                    //Log.d(TAG, "createUserWithEmail:success");
                                    //FirebaseUser user = firebaseAuth.getCurrentUser();
                                    //updateUI(user);
                                } else {

                                    Toast.makeText(SignUp.this, "Registration Error", Toast.LENGTH_LONG).show();

                                    // If sign in fails, display a message to the user.
                                    //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    //Toast.makeText(SignUp.this, "Authentication failed.",
                                            //Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }
                                   progressDialog.dismiss();
                                // ...
                            }

                        });

            }





            @Override
            public void onClick(View view) {

                if (view == buttonRegister)
                {
                    registerUser();
                }
                if (view == textViewLogin)
                {
                    //Will Open Login Activity
                    startActivity(new Intent(getApplicationContext(), Login.class));
                }

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
