package com.example.calmmind;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private boolean Notplaying = true;
    private Button rainButton;
    private Button natureButton;
    private Button relaxButton;
    MediaPlayer mp3rain;
    MediaPlayer mp3nature;
    MediaPlayer mp3relax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mp3rain = MediaPlayer.create(this, R.raw.chuva);
        mp3nature = MediaPlayer.create(this, R.raw.nature);
        mp3relax = MediaPlayer.create(this, R.raw.relax);

        rainButton = findViewById(R.id.rain_id);
        natureButton = findViewById(R.id.nature_id);
        relaxButton = findViewById(R.id.relax_id);
    }

    public void Rain(View view) {
        if (Notplaying) {
            if (mp3rain != null && !mp3rain.isPlaying()) {
                mp3rain.setLooping(true);
                mp3rain.start();
                rainButton.setText(R.string.parar);
                Notplaying = false;
                natureButton.setEnabled(false);
                relaxButton.setEnabled(false);
            }
        }
        else {
            if (mp3rain != null && mp3rain.isPlaying()) {
                mp3rain.stop();
                try {
                    mp3rain.prepare();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                rainButton.setText(R.string.chuva);
                Notplaying = true;
                natureButton.setEnabled(true);
                relaxButton.setEnabled(true);
            }
        }
    }

    public void Nature(View view) {
        if (Notplaying) {
            if (mp3nature != null && !mp3nature.isPlaying()) {
                mp3nature.setLooping(true);
                mp3nature.start();
            }
            natureButton.setText(R.string.parar);
            Notplaying = false;
            rainButton.setEnabled(false);
            relaxButton.setEnabled(false);
        }
        else {
            if (mp3nature != null && mp3nature.isPlaying()) {
                mp3nature.stop();
                try {
                    mp3nature.prepare();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            natureButton.setText(R.string.natureza);
            Notplaying = true;
            rainButton.setEnabled(true);
            relaxButton.setEnabled(true);
        }
    }

    public void Relax(View view) {
        if (Notplaying) {
            if (mp3relax != null && !mp3relax.isPlaying()) {
                mp3relax.setLooping(true);
                mp3relax.start();
            }
            relaxButton.setText(R.string.parar);
            Notplaying = false;
        } else {
            if (mp3relax != null && mp3relax.isPlaying()) {
                mp3relax.stop();
                try {
                    mp3relax.prepare();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            relaxButton.setText(R.string.relaxante);
            Notplaying = true;
            rainButton.setEnabled(true);
            natureButton.setEnabled(true);
        }
    }
}