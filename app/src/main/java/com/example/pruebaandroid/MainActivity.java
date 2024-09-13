package com.example.pruebaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button calcular_imc, conversor_de_moneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        calcular_imc = findViewById(R.id.calcular_imc);
        conversor_de_moneda = findViewById(R.id.conversor_de_moneda);

        calcular_imc.setOnClickListener(view -> {
            Intent intent = new Intent(this, CalcularIMC.class);
            startActivity(intent);
        });

        conversor_de_moneda.setOnClickListener(view -> {
            Intent intent = new Intent(this, ConversorDeMoneda.class);
            startActivity(intent);
        });




    }
}