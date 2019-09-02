package com.example.appandroidrachou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GrenobleActivity extends AppCompatActivity {

    private ImageView appartCompteur;
    private TextView resultCompteur;
    private int clic = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grenoble);

        this.appartCompteur = (ImageView) findViewById(R.id.appartCompteur);
        this.resultCompteur = (TextView) findViewById(R.id.resultCompteur);

        appartCompteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clic--;
                resultCompteur.setText("vous avez cliqué "+clic+" fois");
            }
        });
    }
}
