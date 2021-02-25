package com.example.prachi.project;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Payment extends AppCompatActivity {

    EditText text1,text2,text3,text4;
    Button gen_btn,done,go;
    ImageView image;
    Dialog finall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        text1 = (EditText) findViewById(R.id.text1);
        text2 = (EditText) findViewById(R.id.text2);
        text3 = (EditText) findViewById(R.id.text3);
        text4 = (EditText) findViewById(R.id.text4);
        gen_btn = (Button) findViewById(R.id.gen_btn);
        done=findViewById(R.id.donebtnp);
        finall=new Dialog(this);
        image = (ImageView) findViewById(R.id.image);
        gen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String qrstring = "Name: "+text1.getText().toString().trim()+ "\n" +"Phone Number: +91"+ text2.getText().toString().trim() + "\n" +"Car Number: "+ text3.getText().toString().trim() + "\n" +"Place of Parking: "+ text4.getText().toString().trim();
                if(text1.length() < 10) {
                    text1.setError("Please Enter Your Full Name");
                    text1.requestFocus();
                    return;
                }

                if(text2.length() < 10) {
                    text2.setError("Please Enter a Valid Number");
                    text2.requestFocus();
                    return;
                }

                if(text3.length() < 5) {
                    text3.setError("Please Enter a Valid Number");
                    text3.requestFocus();
                    return;
                }

                if(text4.length() < 4) {
                    text4.setError("Please Enter a Valid Number");
                    text4.requestFocus();
                    return;
                }
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode(qrstring, BarcodeFormat.QR_CODE,170,170);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    image.setImageBitmap(bitmap);
                }
                catch (WriterException e){
                    e.printStackTrace();
                }
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup();
            }
        });
    }
    public void showPopup(){
        finall.setContentView(R.layout.success);
        go=finall.findViewById(R.id.goBack);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finall.dismiss();
                startActivity(new Intent(Payment.this, MapsActivity.class));

           finish(); }
        });
        finall.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        finall.show();
    }
}
