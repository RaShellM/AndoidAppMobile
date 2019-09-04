package com.example.appandroidrachou.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appandroidrachou.Model.User;
import com.example.appandroidrachou.R;

public class MainActivity extends AppCompatActivity {

    private TextView mIdentifMessage;
    private EditText mIdentifInput;
    private Button mIdentifButton;
    private Button mInfoButton;
    private MediaPlayer audio;
    private Button mGameButton;
    private MediaPlayer audiosiffle;
    private User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INSTANCIATIONS
        mIdentifMessage = (TextView) findViewById(R.id.activity_identifiant_identif_text);
        mIdentifInput = (EditText) findViewById(R.id.activity_identifiant_identif_input);
            //identif B
        mIdentifButton = (Button) findViewById(R.id.activity_identifiant_identif_button);
            //game B
        mGameButton = (Button) findViewById(R.id.activity_game_jouer_button);
            //info B
        mInfoButton = (Button) findViewById(R.id.activity_identifiant_info_button);
            //audio
        audio = MediaPlayer.create(getApplicationContext(), R.raw.sncf);
        mUser = new User("default");

        //Bouton initalisés inaccessibles
        mIdentifButton.setEnabled(false);
        mGameButton.setEnabled(false);
        //M Listener sur Identification Remplie
        mIdentifInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mIdentifButton.setEnabled(s.toString().length()>3);
                mGameButton.setEnabled(s.toString().length()>3);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        //M aller vers LOCATION
        mIdentifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputPrenom = mIdentifInput.getText().toString();
                mUser.setIdentifiant(inputPrenom);
                //button clicked
                Intent pageLocation = new Intent(getApplicationContext(), LocationActivity.class);
                startActivity(pageLocation);
                finish();
            }
        });
        //M aller vers GAME
       mGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audiosiffle = MediaPlayer.create(MainActivity.this, R.raw.siffle);
                audiosiffle.start();
                Intent pageGame = new Intent (MainActivity.this, GameActivity.class);
                startActivity(pageGame);
                finish();
            }
        });
    }
    public void chante (View view){
        audio.start();
    }
}