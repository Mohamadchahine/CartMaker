package com.cartmaker.cartmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    ImageView profile;

    TextView name, phone, email, adress, plat1, plat2;
    String Sname, Sphone, Semail, Sadress, Splat1, Splat2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        declare();

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String uriString = bundle.getString("profile");
            if (uriString != null) {
                Uri uri = Uri.parse(uriString);
                profile.setImageURI(uri);
            }
        }

        Sname = bundle.getString("name");
        Sphone = bundle.getString("phone");
        Semail = bundle.getString("email");
        Sadress = bundle.getString("address");
        Splat1 = bundle.getString("plat1");
        Splat2 = bundle.getString("plat2");

        name.setText(Sname);
        phone.setText(Sphone);
        email.setText(Semail);
        adress.setText(Sadress);
        plat1.setText(Splat1);
        plat2.setText(Splat2);






    }

    public void declare(){
        profile = findViewById(R.id.imageprofile);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        adress = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        plat1 = findViewById(R.id.plat1);
        plat2 = findViewById(R.id.plat2);
    }
}