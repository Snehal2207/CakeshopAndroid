package com.example.cakeshopip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetailActivity extends AppCompatActivity {

    ImageView imgDetail;
    TextView txtName;
    TextView txtPrice;
    Button btnToCheckout;
    TextView txtDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i=getIntent();
        String image=i.getStringExtra("image");
        String name=i.getStringExtra("name");
        String price=i.getStringExtra("price");
        String detail=i.getStringExtra("detail");


        imgDetail=(ImageView) findViewById(R.id.imgDetail);
        txtName=(TextView) findViewById(R.id.txtDetailName);
        txtPrice=(TextView) findViewById(R.id.txtDetailprice);
        btnToCheckout=(Button)findViewById(R.id.btnToCheckout);
        txtDetail=(TextView)findViewById(R.id.txtDetailD);

        btnToCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DetailActivity.this,CheckoutActivity.class);
                i.putExtra("name",name);
                i.putExtra("price",price);
//                i.putExtra("detail",detail);
                startActivity(i);
            }
        });


        Glide.with(this).load(image)
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(imgDetail);
        txtName.setText(name);
        txtPrice.setText(price);
        txtDetail.setText(detail);
    }




}