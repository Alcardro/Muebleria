package com.example.muebleria;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class LoginmenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_menu);
        Log.d("LoginmenuActivity", "Activity created");

        // Código de configuración de la barra de estado...

        ConstraintLayout layoutClientes = findViewById(R.id.layout_clientes);
        layoutClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LoginmenuActivity", "Clientes button clicked");
                Intent intent = new Intent(LoginmenuActivity.this, ClientesActivity.class);
                startActivity(intent);
            }
        });
    }
}