package com.example.cakeshopip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    TextView txtName;
    TextView txtPrice;
    TextView txtTPrice;
    Button btnPurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        txtName=findViewById(R.id.txtNameC);
        txtPrice=findViewById(R.id.txtPriceC);
        txtTPrice=findViewById(R.id.txtTPriceC);
        btnPurchase=findViewById(R.id.btnPurchase);

        Intent i=getIntent();
        String name=i.getStringExtra("name");
        String price=i.getStringExtra("price");

        txtName.setText("Name: "+name);
        txtPrice.setText("Price: "+price);
        txtTPrice.setText("Total Amount: "+price);

        btnPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDailog myDailog=new MyDailog();
                myDailog.show(getSupportFragmentManager(),"123");
            }
        });
    }
}