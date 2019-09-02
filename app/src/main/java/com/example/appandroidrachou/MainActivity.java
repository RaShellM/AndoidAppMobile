package com.example.appandroidrachou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView gre;
    private TextView mMessage;
    private EditText identifiantInput;
    private Button mIdentifButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
