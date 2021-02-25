package com.example.prachi.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;
    private TextView forgotPassword;


    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(getApplicationContext(), Page1Activity.class));
        }

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        textViewSignup = (TextView) findViewById(R.id.textViewSignup);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);

        buttonSignIn.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);

forgotPassword.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(LoginActivity.this, PasswordActivity.class));
    }
});


    }


    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            // email is emptyyy
            Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show();
            //stopping the function excuting here
            return;
        }


        if (TextUtils.isEmpty(password)) {
            // password is empty
            Toast.makeText(this, "Password", Toast.LENGTH_SHORT).show();
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), Page1Activity.class));
                            Toast.makeText(LoginActivity.this, "ParkIN Welcomes You!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Email or Password is wrong. Please Try Again!", Toast.LENGTH_SHORT).show();

                        }
                    }


                });

    }

    @Override
    public void onClick(View view) {
        if(view == buttonSignIn) {
            userLogin();
            }

            if(view == textViewSignup) {
            finish();
            startActivity(new Intent(this, MainActivity.class));

        }

    }
}
