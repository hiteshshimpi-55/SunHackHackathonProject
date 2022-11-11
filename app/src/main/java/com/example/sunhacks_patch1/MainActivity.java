package com.example.sunhacks_patch1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunhacks_patch1.ModelAdapter.ModelAdapterClass;
import com.example.sunhacks_patch1.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    List<ModelClass> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        startActivity(new Intent(this,MapsActivity.class));

        recyclerView = findViewById(R.id.recyclerView);
        floatingActionButton = findViewById(R.id.floatingActionButton);



        //Model Dataset

        list =  new ArrayList<>();
        list.add(new ModelClass("Red Fort","Red Fort, also called Lal Qalʿah, also spelled Lal Kila\n" +
                " or Lal Qila, Mughal fort in Old Delhi, India. It was built by Shah Jahān in the mid-17th century and\n" +
                " remains a major tourist attraction. The fort was designated a UNESCO World Heritag site in 2007.","RED FORT"," ",28.6562,77.2410));

        list.add(new ModelClass("Taj mahal","The Taj Mahal (/ˌtɑːdʒ məˈhɑːl, ˌtɑːʒ-/; \n" + "lit. 'Crown of the Palace'),[4][5][6] is an Islamic ivory-white marble mausol\n" +
                "eum on the right bank of the river Yamuna in the Indian city of Agra.\n" + " It was commissioned in 1631 by the Mughal emperor Shah Jahan (r. 1628–1658) to \n" +
                "house the tomb of his favourite wife, Mumtaz Mahal; it also houses the tomb of Shah Jahan himself.\n" +
                " The tomb is the centrepiece of a 17-hectare (42-acre) complex, which includes a mosque and a guest house, \n" +
                "and is set in formal gardens bounded on three sides by a crenellated wall.","TAJ MAHAL"," ",28.6562,77.2410));
        list.add(new ModelClass("Gate way of India","The Gateway of India is an arch-monument built in the early 20th century in the city of Bombay (Mumbai), India. It was erected to commemorate the landing of King-Emperor George V, the first British monarch to visit India, in December 1911 at Strand Road near Wellington Fountain.\n" +
                "\n" + "The foundation stone was laid in March 1913 for a monument built in the Indo-Islamic style, inspiring by elements of 16th-century Gujarati architecture. The final design \n" +
                "of the monument by architect George Wittet was sanctioned only in 1914, and construction was completed in 1924. The structure is a memorial arch made of basalt,\n" +
                " which is 26 metres (85 feet) high, with an architectural resemblance to a triumphial arch as well as Gujarati architecture of the \n" +
                "time."," ","GATEWAY OF INDIA",18.9220,72.8347));
        list.add(new ModelClass("Ajanta Caves","The Ajanta Caves are approximately 30 rock-cut Buddhist \n" +
                "cave monuments dating from the 2nd century BCE to about 480 CE in the Aurangabad district of Maharashtra\n" +
                " state in India.[1][note 1] The caves include paintings and rock-cut sculptures described as among the finest\n" +
                " surviving examples of ancient Indian art, particularly expressive paintings that present emotions through gesture,\n" +
                " pose and form","AJANTA CAVES"," ",20.5519,75.7033));


        list.get(2).setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Mumbai_03-2016_30_Gateway_of_India.jpg/800px-Mumbai_03-2016_30_Gateway_of_India.jpg");
        list.get(0).setImageUrl("https://cdn.britannica.com/75/152475-050-DA89FF0A/Red-Fort-Old-Delhi-India.jpg");
        list.get(1).setImageUrl("https://cdn.britannica.com/86/170586-050-AB7FEFAE/Taj-Mahal-Agra-India.jpg");
        list.get(3).setImageUrl("https://www.onacheaptrip.com/wp-content/uploads/Kailasa-Temple-at-Ellora-Caves-Aurangabad.jpg");


        ModelAdapterClass adapter = new ModelAdapterClass(list,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MapsActivity.class));
            }
        });
    }

}
