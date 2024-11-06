package com.example.muebleria;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class SurveyActivityPageFour extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Aquí conectas tu layout con la actividad
        setContentView(R.layout.survey_activity_page_four);  // Asegúrate de que el nombre del layout sea correcto


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }


        Button button = findViewById(R.id.nextpagefour);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SurveyActivityPageFour.this,SurveyActivityResult.class);
                startActivity(intent);
            }
        });










        EditText responseOpen = findViewById(R.id.response_open);

// Obtener el texto ingresado por el usuario
        String respuestaAbierta = responseOpen.getText().toString();

// Luego, puedes hacer lo que necesites con la respuesta, como enviarla a una base de datos o mostrarla.


    }
}