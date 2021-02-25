package com.example.prachi.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Card extends AppCompatActivity {
    CardView c1,c2,c3,c4,c5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        c1=findViewById(R.id.card1);
        c2=findViewById(R.id.card2);
        c3=findViewById(R.id.card3);
        c4=findViewById(R.id.card4);
        c5=findViewById(R.id.card5);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Card.this,SeatSelection.class);
                startActivity(i);
                finish();
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Card.this,SeatSelection.class);
                startActivity(i);
                finish();
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Card.this,SeatSelection.class);
                startActivity(i);
                finish();
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Card.this,SeatSelection.class);
                startActivity(i);
                finish();
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Card.this,SeatSelection.class);
                startActivity(i);
                finish();
            }
        });


    }
}
