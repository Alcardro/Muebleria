package com.example.muebleria;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.DocumentReference;
import java.util.HashMap;
import java.util.Map;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class CostumerActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhone, editTextAge;
    private Button costumerSurvey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Aquí conectas tu layout con la actividad
        setContentView(R.layout.costumer_activity);  // Asegúrate de que el nombre del layout sea correcto

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }

        Button button = findViewById(R.id.costumerSurveyAdvance);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CostumerActivity.this, SurveyActivity.class);
                startActivity(intent);
            }
        });



        // Inicializa los elementos de UI
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAge = findViewById(R.id.editTextAge);
        costumerSurvey = findViewById(R.id.costumerSurvey);

        // Establece el OnClickListener para el botón
        costumerSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String phone = editTextPhone.getText().toString();
                String age = editTextAge.getText().toString();

                // Guardamos los datos en Firestore
                saveDataToFirestore(name, email, phone, age);
            }
        });
    }

    private void saveDataToFirestore(String name, String email, String phone, String age) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Crea un nuevo documento con los datos
        Map<String, Object> customerData = new HashMap<>();
        customerData.put("name", name);
        customerData.put("email", email);
        customerData.put("phone", phone);
        customerData.put("age", age);

        // Agrega un nuevo documento con un ID generado automáticamente
        db.collection("clientes")
                .add(customerData)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(CostumerActivity.this, "Cliente agregado con ID: " + documentReference.getId(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CostumerActivity.this, "Error al agregar cliente", Toast.LENGTH_SHORT).show();
                    }
                });


    }
}
