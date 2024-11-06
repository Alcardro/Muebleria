package com.example.muebleria;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class SurveyActivityPageThree extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Aquí conectas tu layout con la actividad
        setContentView(R.layout.survey_activity_page_three);  // Asegúrate de que el nombre del layout sea correcto

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }

        Button button = findViewById(R.id.nextpagethree);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SurveyActivityPageThree.this,SurveyActivityPageFour.class);
                startActivity(intent);
            }
        });





        RadioGroup radioGroup = findViewById(R.id.radioGroup7);
        RadioButton radioYes = findViewById(R.id.radioYes7);
        RadioButton radioNo = findViewById(R.id.radioNo7);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioYes7) {
                    // El usuario seleccionó 'Sí'
                } else if (checkedId == R.id.radioNo7) {
                    // El usuario seleccionó 'No'
                }
            }
        });




        RatingBar ratingBar8 = findViewById(R.id.rBpregunta8);
        final TextView ratingValue5 = findViewById(R.id.rBvpregunta8);

        ratingBar8.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue5.setText("Puntuación: " + (int) rating);
            }
        });




        RatingBar ratingBar9 = findViewById(R.id.rBpregunta9);
        final TextView ratingValue9 = findViewById(R.id.rBvpregunta9);

        ratingBar9.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue9.setText("Puntuación: " + (int) rating);
            }
        });

    }
}