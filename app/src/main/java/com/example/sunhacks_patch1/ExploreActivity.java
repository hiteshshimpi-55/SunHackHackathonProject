package com.example.sunhacks_patch1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ExploreActivity extends AppCompatActivity {

    ImageView backgroundImage;
    TextView title,about,lat,lng;
    Button mapBtn;
    ModelClass myObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        // initialize
        backgroundImage = findViewById(R.id.imageView2);
        title = findViewById(R.id.explore_title);
        about = findViewById(R.id.explore_about);
        mapBtn = findViewById(R.id.mapBtn);
        lat    = findViewById(R.id.explore_lat);
        lng    = findViewById(R.id.explore_lng);
        myObj = (ModelClass)getIntent().getSerializableExtra("ModelObject");

        Glide.with(getApplicationContext()).load(myObj.getImageUrl()).into(backgroundImage);

        title.setText(myObj.getTitle());
        about.setText(myObj.getAbout());

        lat.setText(String.valueOf(myObj.latitude));
        lng.setText(String.valueOf(myObj.longitude));


        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:"+myObj.getLatitude()+","+myObj.getLongitude());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });


    }
}