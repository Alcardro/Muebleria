package com.example.muebleria;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SurveyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Aquí conectas tu layout con la actividad
        setContentView(R.layout.survey_acivity);  // Asegúrate de que el nombre del layout sea correcto


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }

        Button button = findViewById(R.id.nextpage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SurveyActivity.this,SurveyActivityPageTwo.class);
                startActivity(intent);
            }
        });



        RatingBar ratingBar = findViewById(R.id.rBpregunta1);
        final TextView ratingValue = findViewById(R.id.rBvpregunta1);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue.setText("Puntuación: " + (int) rating);
            }
        });


        RatingBar ratingBar2 = findViewById(R.id.rBpregunta2);
        final TextView ratingValue2 = findViewById(R.id.rBvpregunta2);

        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue2.setText("Puntuación: " + (int) rating);
            }
        });


        RatingBar ratingBar3 = findViewById(R.id.rBpregunta3);
        final TextView ratingValue3 = findViewById(R.id.rBvpregunta3);

        ratingBar3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue3.setText("Puntuación: " + (int) rating);
            }
        });



    }
}