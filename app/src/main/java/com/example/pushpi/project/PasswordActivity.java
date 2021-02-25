package com.example.prachi.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordActivity extends AppCompatActivity {

    private EditText emailReset;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        emailReset = (EditText) findViewById(R.id.emailReset);
        resetPassword = (Button) findViewById(R.id.resetPassword);
        firebaseAuth = FirebaseAuth.getInstance();


        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String useremail = emailReset.getText().toString().trim();

            if(useremail.equals("")) {
                Toast.makeText(PasswordActivity.this, "Please Enter your Registered Email ID",Toast.LENGTH_SHORT);
            }
            else {
                firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                     if(task.isSuccessful()) {
                         Toast.makeText(PasswordActivity.this, "Password Reset Email sent!",Toast.LENGTH_SHORT);
                         finish();
                         startActivity(new Intent(PasswordActivity.this, LoginActivity.class));
                     }
                     else {
                         Toast.makeText(PasswordActivity.this, "Error Occur in Sending Email",Toast.LENGTH_SHORT);
                     }
                    }
                });
            }
            }
        });
    }
}
