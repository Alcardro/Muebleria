package com.example.muebleria;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class ClientesActivity extends AppCompatActivity {

    EditText edtNombre, edtParametro1, edtParametro2, edtParametro3, edtParametro4;
    Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientes_activity);

        edtNombre = findViewById(R.id.editTextNombre);
        edtParametro1 = findViewById(R.id.editTextParametro1);
        edtParametro2 = findViewById(R.id.editTextParametro2);
        edtParametro3 = findViewById(R.id.editTextParametro3);
        edtParametro4 = findViewById(R.id.editTextParametro4);
        btnBuscar = findViewById(R.id.buttonBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombre.getText().toString();
                buscarDatos(nombre);
            }
        });
    }

    private void buscarDatos(String nombre) {
        // Primero intentamos buscar en Firebase Realtime Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("clientes"); // Nombre de tu referencia en la base de datos

        myRef.orderByChild("nombre").equalTo(nombre).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Si encontramos el cliente en Realtime Database, lo mostramos
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String parametro1 = snapshot.child("parametro1").getValue(String.class);
                        String parametro2 = snapshot.child("parametro2").getValue(String.class);
                        String parametro3 = snapshot.child("parametro3").getValue(String.class);
                        String parametro4 = snapshot.child("parametro4").getValue(String.class);

                        edtParametro1.setText(parametro1);
                        edtParametro2.setText(parametro2);
                        edtParametro3.setText(parametro3);
                        edtParametro4.setText(parametro4);
                    }
                } else {
                    // Si no encontramos el cliente en Realtime Database, intentamos con Firestore
                    buscarDatosEnFirestore(nombre);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Firebase", "Error al leer los datos: " + databaseError.getMessage());
            }
        });
    }

    private void buscarDatosEnFirestore(String nombre) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Buscamos en Firestore
        db.collection("clientes")  // Nombre de tu colección en Firestore
                .whereEqualTo("nombre", nombre)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String parametro1 = document.getString("parametro1");
                            String parametro2 = document.getString("parametro2");
                            String parametro3 = document.getString("parametro3");
                            String parametro4 = document.getString("parametro4");

                            edtParametro1.setText(parametro1);
                            edtParametro2.setText(parametro2);
                            edtParametro3.setText(parametro3);
                            edtParametro4.setText(parametro4);
                        }
                    } else {
                        Log.d("Firestore", "Error al obtener documentos: ", task.getException());
                    }
                });
    }
}
