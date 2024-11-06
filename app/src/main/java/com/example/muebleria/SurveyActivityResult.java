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

public class SurveyActivityResult extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Aquí conectas tu layout con la actividad
        setContentView(R.layout.survey_activity_result);  // Asegúrate de que el nombre del layout sea correcto


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }



// Supongamos que tienes estas variables con las respuestas
        String nombre = "Juan Pérez"; // Reemplaza con la variable que almacena el nombre
        String edad = "25"; // Reemplaza con la variable que almacena la edad
        String telefono = "987654321"; // Reemplaza con la variable que almacena el teléfono
        String correo = "juan@example.com"; // Reemplaza con la variable que almacena el correo

// En tu onCreate() o en el método correspondiente
        TextView responseName = findViewById(R.id.response_name);
        TextView responseAge = findViewById(R.id.response_age);
        TextView responsePhone = findViewById(R.id.response_phone);
        TextView responseEmail = findViewById(R.id.response_email);

        responseName.setText("Nombre: " + nombre);
        responseAge.setText("Edad: " + edad);
        responsePhone.setText("Teléfono: " + telefono);
        responseEmail.setText("Correo: " + correo);







    }
}