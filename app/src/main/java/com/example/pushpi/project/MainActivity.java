package com.example.prachi.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button buttonRegister;
    private EditText editTextEmail,editTextName;
    private EditText editTextPassword, editTextPassword2;
    private TextView textViewSignin;

    public ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPassword2 = (EditText) findViewById(R.id.editTextPassword2);

        textViewSignin = (TextView) findViewById(R.id.textViewSignin);

        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
        }

    @Override
    protected void onStart() {
        super.onStart();

        if(firebaseAuth.getCurrentUser() != null) {

        }
    }

    private void registerUser() {
              final String email = editTextEmail.getText().toString().trim();
              final String name = editTextName.getText().toString().trim();
              final String password = editTextPassword.getText().toString().trim();
              String password1 = editTextPassword2.getText().toString().trim();



              if (name.length() < 10) {
                  editTextName.setError("Please Enter Your Full Name");
                  editTextName.requestFocus();
                  return;
              }

              if (TextUtils.isEmpty(email)) {
                  editTextEmail.setError("Enter your email address");
                  editTextEmail.requestFocus();
                  return;
              }


              if (password.length() < 8) {
                  // password is empty
                  editTextPassword.setError("Entered password must contains 8 characters");
                  editTextPassword.requestFocus();
                  return;
              }

              if (password1.length() < 8) {
                  // password is empty
                  editTextPassword2.setError("Entered password must be same");
                  editTextPassword2.requestFocus();
                  return;
              }




              firebaseAuth.createUserWithEmailAndPassword(email, password)
                      .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                          @Override
                          public void onComplete(@NonNull Task<AuthResult> task) {
                              if (task.isSuccessful()) {
                                  Toast.makeText(MainActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                  User user = new User(
                                          name,
                                          email,
                                          password

                                  );
                                  FirebaseDatabase.getInstance().getReference("Users")
                                          .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                          .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                      @Override
                                      public void onComplete(@NonNull Task<Void> task) {
                                          if(task.isSuccessful())
                                              Toast.makeText(MainActivity.this, "Now You are a Member of ParkIN!", Toast.LENGTH_SHORT).show();
                                      }
                                  });
                              } else {
                                  Toast.makeText(MainActivity.this, "Enter a Valid Email address!", Toast.LENGTH_SHORT).show();
                              }


                          }


                      });

          }

    @Override
    public void onClick(View view) {
        if(view == buttonRegister) {
            registerUser();
        }

        if(view == textViewSignin) {
            startActivity(new Intent(this, LoginActivity.class));

        }
    }

    }