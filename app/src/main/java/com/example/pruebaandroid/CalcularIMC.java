package com.example.pruebaandroid;

// Importamos las clases necesarias para la actividad de Android.
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// Clase principal que extiende AppCompatActivity, lo que permite usar las características de la biblioteca de compatibilidad de Android.
public class CalcularIMC extends AppCompatActivity {

    // Definimos variables privadas para los elementos de la interfaz de usuario.
    private EditText editTextPeso, editTextAltura;
    private Button buttonCalcular, buttonVolverIMC;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecemos el diseño de la actividad, el archivo XML de diseño debe estar en la carpeta 'res/layout'.
        setContentView(R.layout.calcularimc);

        // Asociamos las variables de interfaz con los elementos del XML mediante sus IDs.
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttonVolverIMC = findViewById(R.id.buttonVolverIMC);

        // Configuramos un Listener para el botón "Calcular" para que llame al método calcularIMC() cuando se haga clic.
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC(); // Llamamos al método para calcular el IMC.
            }
        });

        // Configuramos un Listener para el botón "Volver" para que cierre la actividad actual cuando se haga clic.
        buttonVolverIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad actual y vuelve a la pantalla anterior.
            }
        });
    }

    // Método que realiza el cálculo del IMC (Índice de Masa Corporal).
    private void calcularIMC() {
        // Obtenemos los valores introducidos en los campos de texto.
        String pesoStr = editTextPeso.getText().toString();
        String alturaStr = editTextAltura.getText().toString();

        // Validamos que los campos no estén vacíos antes de realizar el cálculo.
        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            textViewResultado.setText("Por favor, complete todos los campos."); // Mostramos un mensaje de error si algún campo está vacío.
            return; // Salimos del método si los campos están vacíos.
        }

        // Convertimos los valores de texto a números flotantes.
        float peso = Float.parseFloat(pesoStr);
        float alturaCm = Float.parseFloat(alturaStr);

        // Convertimos la altura de centímetros a metros.
        float alturaM = alturaCm / 100;

        // Calculamos el IMC utilizando la fórmula: peso / (altura en metros)^2.
        float imc = peso / (alturaM * alturaM);

        // Determinamos el rango del IMC usando el método obtenerRangoIMC().
        String rangoIMC = obtenerRangoIMC(imc);

        // Mostramos el resultado en el TextView con el IMC calculado y el rango correspondiente.
        textViewResultado.setText(String.format("Resultado: %.2f\n%s", imc, rangoIMC));
    }

    // Método para determinar el rango del IMC basado en el valor calculado.
    private String obtenerRangoIMC(float imc) {
        // Usamos condicionales para determinar el rango del IMC.
        if (imc < 18.5) {
            return "Bajo peso"; // IMC menor a 18.5
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Normal"; // IMC entre 18.5 y 24.9
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso"; // IMC entre 25 y 29.9
        } else {
            return "Obesidad"; // IMC mayor o igual a 30
        }
    }

}
