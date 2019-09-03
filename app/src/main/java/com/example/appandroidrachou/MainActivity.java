package com.example.appandroidrachou;

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

import com.example.appandroidrachou.Controller.GameActivity;
import com.example.appandroidrachou.Model.User;

import java.util.List;

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
        mIdentifButton = (Button) findViewById(R.id.activity_identifiant_identif_button);
            //game
        mGameButton = (Button) findViewById(R.id.activity_game_jouer_button);
            //info
        mInfoButton = (Button) findViewById(R.id.activity_identifiant_info_button);
            //audio
        audio = MediaPlayer.create(getApplicationContext(), R.raw.sncf);
        mUser = new User("default");

        //METHODE identif
        mIdentifButton.setEnabled(false);
        //METHODE Listener sur input identif
        mIdentifInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mIdentifButton.setEnabled(s.toString().length()>3);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //METHODE aller vers LOCATION
        mIdentifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUser.setIdentifiant(mIdentifInput.getText().toString());
                Intent pageLocation = new Intent(getApplicationContext(), LocationActivity.class);
                startActivity(pageLocation);
                finish();
            }
        });
        //METHODE aller vers game
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