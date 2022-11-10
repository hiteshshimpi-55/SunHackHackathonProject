package com.example.sunhacks_patch1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView loadHomeFragment, loadSurveyFragment, loadChatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadHomeFragment = findViewById(R.id.load_home_fragment);
        loadSurveyFragment = findViewById(R.id.load_survey_fragment);
        loadChatFragment = findViewById(R.id.load_chat_fragment);

        loadHomeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.page_holder, new HomeFragment());
                ft.commit();
            }
        });

        loadSurveyFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Survey Fragment", Toast.LENGTH_SHORT).show();
            }
        });

        loadChatFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Chat Fragment", Toast.LENGTH_SHORT).show();
            }
        });

    }
}