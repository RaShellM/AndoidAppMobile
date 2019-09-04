package com.example.appandroidrachou.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appandroidrachou.GrenobleActivity;
import com.example.appandroidrachou.R;

public class LocationActivity extends AppCompatActivity {
    private ImageView gre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        this.gre = findViewById(R.id.grenobleImg);
        gre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pageGrenoble = new Intent(getApplicationContext(), GrenobleActivity.class);
                startActivity(pageGrenoble);
                finish();

            }
        });
    }
}