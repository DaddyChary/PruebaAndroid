package com.example.pruebaandroid;

// Importamos las clases necesarias para la actividad de Android.
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConversorDeMoneda extends AppCompatActivity {

    // Definimos variables privadas para los elementos de la interfaz de usuario.
    private EditText editTextCantidad;
    private TextView textViewResultado;

    // Definimos las tasas de conversión para las diferentes monedas.
    private static final double USD_CONVERSION_RATE = 0.0012;
    private static final double EUR_CONVERSION_RATE = 0.0011;
    private static final double GBP_CONVERSION_RATE = 0.0009;
    private static final double JPY_CONVERSION_RATE = 0.171;
    private static final double CNY_CONVERSION_RATE = 0.0084;
    private static final double MXN_CONVERSION_RATE = 0.022;
    private static final double BRL_CONVERSION_RATE = 0.0061;
    private static final double CAD_CONVERSION_RATE = 0.0016;
    private static final double AUD_CONVERSION_RATE = 0.0018;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecemos el diseño de la actividad, el archivo XML de diseño debe estar en la carpeta 'res/layout'.
        setContentView(R.layout.conversormoneda);

        // Inicializamos las vistas asociando los elementos del XML con las variables.
        editTextCantidad = findViewById(R.id.editTextCantidad);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Inicializamos los botones para cada moneda y les asignamos un Listener para manejar los clics.
        Button buttonUSD = findViewById(R.id.buttonUSD);
        Button buttonEUR = findViewById(R.id.buttonEUR);
        Button buttonGBP = findViewById(R.id.buttonGBP);
        Button buttonJPY = findViewById(R.id.buttonJPY);
        Button buttonCNY = findViewById(R.id.buttonCNY);
        Button buttonMXN = findViewById(R.id.buttonMXN);
        Button buttonBRL = findViewById(R.id.buttonBRL);
        Button buttonCAD = findViewById(R.id.buttonCAD);
        Button buttonAUD = findViewById(R.id.buttonAUD);

        // Configuramos los Listeners para cada botón, llamando al método convertToCurrency() con la tasa de conversión correspondiente.
        buttonUSD.setOnClickListener(v -> convertToCurrency(USD_CONVERSION_RATE, "USD"));
        buttonEUR.setOnClickListener(v -> convertToCurrency(EUR_CONVERSION_RATE, "EUR"));
        buttonGBP.setOnClickListener(v -> convertToCurrency(GBP_CONVERSION_RATE, "GBP"));
        buttonJPY.setOnClickListener(v -> convertToCurrency(JPY_CONVERSION_RATE, "JPY"));
        buttonCNY.setOnClickListener(v -> convertToCurrency(CNY_CONVERSION_RATE, "CNY"));
        buttonMXN.setOnClickListener(v -> convertToCurrency(MXN_CONVERSION_RATE, "MXN"));
        buttonBRL.setOnClickListener(v -> convertToCurrency(BRL_CONVERSION_RATE, "BRL"));
        buttonCAD.setOnClickListener(v -> convertToCurrency(CAD_CONVERSION_RATE, "CAD"));
        buttonAUD.setOnClickListener(v -> convertToCurrency(AUD_CONVERSION_RATE, "AUD"));

        // Inicializamos el botón "Volver" para cerrar la actividad cuando se haga clic.
        Button buttonVolver = findViewById(R.id.buttonVolverIMC);
        buttonVolver.setOnClickListener(v -> finish()); // Cierra la actividad actual.
    }

    // Método que realiza la conversión de la cantidad de CLP a la moneda seleccionada.
    private void convertToCurrency(double conversionRate, String tipo) {
        // Obtenemos el valor introducido en el campo de texto.
        String input = editTextCantidad.getText().toString();
        if (input.isEmpty()) {
            // Si el campo está vacío, mostramos un mensaje de error.
            textViewResultado.setText("Ingrese un monto en CLP");
            return;
        }

        try {
            // Convertimos el valor de texto a un número decimal.
            double amountCLP = Double.parseDouble(input);
            // Realizamos la conversión usando la tasa de conversión.
            double convertedAmount = amountCLP * conversionRate;
            // Mostramos el resultado en el TextView con el monto convertido y la moneda correspondiente.
            textViewResultado.setText(String.format("Resultado: %.2f %s", convertedAmount, tipo));
        } catch (NumberFormatException e) {
            // Si ocurre una excepción de formato, mostramos un mensaje de error.
            textViewResultado.setText("Monto inválido");
        }
    }
}
