package com.example.muebleria;

import android.content.Intent;
import android.graphics.Color;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;



public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }

         //Configuración del botón en el layout principal
        Button button = findViewById(R.id.costumerActivity);
        button.setOnClickListener(view -> {
             //Muestra un Toast antes de iniciar la actividad
            Toast.makeText(MainActivity.this, "Abriendo actividad de cliente...", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, CostumerActivity.class);
            startActivity(intent);
        });



        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_login) {
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }else if (id == R.id.nav_home) {
                // Si el usuario está en MainActivity, muestra un mensaje
                Toast.makeText(MainActivity.this, "Ya estás en la pantalla de inicio", Toast.LENGTH_SHORT).show();
            }

            // Cierra el Drawer después de manejar la acción
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });



        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.insertUser("admin", "admin"); // Usuario y contraseña de prueba




    }


}
