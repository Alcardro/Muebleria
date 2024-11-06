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

public class SurveyActivityPageTwo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Aquí conectas tu layout con la actividad
        setContentView(R.layout.survey_activity_page_two);  // Asegúrate de que el nombre del layout sea correcto

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }





        Button button = findViewById(R.id.nextpagetwo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SurveyActivityPageTwo.this,SurveyActivityPageThree.class);
                startActivity(intent);
            }
        });








        RatingBar ratingBar4 = findViewById(R.id.rBpregunta4);
        final TextView ratingValue4 = findViewById(R.id.rBvpregunta4);

        ratingBar4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue4.setText("Puntuación: " + (int) rating);
            }
        });




        RatingBar ratingBar5 = findViewById(R.id.rBpregunta5);
        final TextView ratingValue5 = findViewById(R.id.rBvpregunta5);

        ratingBar5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue5.setText("Puntuación: " + (int) rating);
            }
        });



        RatingBar ratingBar6 = findViewById(R.id.rBpregunta6);
        final TextView ratingValue6 = findViewById(R.id.rBvpregunta6);

        ratingBar6.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue6.setText("Puntuación: " + (int) rating);
            }
        });

    }
}