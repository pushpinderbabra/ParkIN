package com.example.prachi.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Main4Activity extends AppCompatActivity {

    Button pk1,pk2,pk3,pk4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        pk1=findViewById(R.id.parking1);
        pk2=findViewById(R.id.parking2);
        pk3=findViewById(R.id.parking3);
        pk4=findViewById(R.id.parking4);
        pk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selection=new Intent(Main4Activity.this,SeatSelection.class);
                startActivity(selection);
            }
        });
        pk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selection=new Intent(Main4Activity.this,SeatSelection.class);
                startActivity(selection);
            }
        });
        pk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selection=new Intent(Main4Activity.this,SeatSelection.class);
                startActivity(selection);
            }
        });
        pk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selection=new Intent(Main4Activity.this,SeatSelection.class);
                startActivity(selection);
            }
        });
    }

}
