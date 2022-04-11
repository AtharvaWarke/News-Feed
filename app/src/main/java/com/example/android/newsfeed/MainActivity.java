package com.example.android.newsfeed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button businessButton;
        Button sportsButton;
        Button generalButton;
        Button scienceButton;
        Button entertainmentButton;
        Button technologyButton;
        Button healthButton;


        businessButton = findViewById(R.id.businessButton);
        businessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUrl("business");
                intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        sportsButton = findViewById(R.id.sportsButton);
        sportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUrl("sports");
                intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("url", url);
                startActivity(intent);

            }
        });
        generalButton = findViewById(R.id.generaButton);
        generalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUrl("general");
                intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("url", url);
                startActivity(intent);

            }
        });
        entertainmentButton = findViewById(R.id.entertainmentButton);
        entertainmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUrl("entertainment");
                intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("url", url);
                startActivity(intent);

            }
        });
        healthButton = findViewById(R.id.healthButton);
        healthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUrl("health");
                intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("url", url);
                startActivity(intent);

            }
        });
        scienceButton = findViewById(R.id.scienceButton);
        scienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUrl("science");
                intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("url", url);
                startActivity(intent);

            }
        });
        technologyButton = findViewById(R.id.technologyButton);
        technologyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUrl("technology");
                intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("url", url);
                startActivity(intent);

            }
        });
    }

    public String setUrl(String category) {
        url = "https://saurav.tech/NewsAPI/top-headlines/category/" + category + "/in.json";
        return url;
    }
}