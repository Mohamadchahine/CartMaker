package com.cartmaker.cartmaker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;

public class Home extends AppCompatActivity {

    ImageView profile;
    EditText name, phone, email, address, plat1, plat2;
    Button bt ;

    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profile = findViewById(R.id.ProfileImage);
        name=findViewById(R.id.edName);
        phone =findViewById(R.id.edPhone);
        email =findViewById(R.id.edEmail);
        address =findViewById(R.id.edAddress);
        plat1=findViewById(R.id.edPlat1);
        plat2=findViewById(R.id.edPlat2);
        bt =findViewById(R.id.button);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImagePicker.with(Home.this)
                        .cropSquare()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,Result.class);
                try{

                    if(name.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || email.getText().toString().isEmpty()) {
                        Toast.makeText(Home.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                    }else{
                        i.putExtra("name",name.getText().toString());
                        i.putExtra("phone",phone.getText().toString());
                        i.putExtra("email",email.getText().toString());
                        i.putExtra("address",address.getText().toString());
                        i.putExtra("plat1",plat1.getText().toString());
                        i.putExtra("plat2",plat2.getText().toString());
                        i.putExtra("profile",uri.toString());
                        startActivity(i);
                    }

                }catch (Exception ex){
                    Toast.makeText(Home.this, "Error! Please add a Image", Toast.LENGTH_SHORT).show();
                }




            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        uri = data.getData();
        profile.setImageURI(uri);
    }
}