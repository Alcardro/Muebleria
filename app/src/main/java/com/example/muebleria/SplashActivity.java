package com.example.muebleria;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity); // Cambia esto si usas otro layout para el splash

        getWindow().setStatusBarColor(Color.TRANSPARENT);

        // Usar Handler para esperar 8 segundos
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Termina SplashActivity
        }, 3000); // 8000 milisegundos = 8 segundos
    }
}