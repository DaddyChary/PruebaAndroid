# De que se trata?

El proyecto es una aplicación Android para conversión de moneda y cálculo del Índice de Masa Corporal (IMC). Aquí está una descripción detallada del proyecto:

1. Calculadora del IMC
    Objetivo
    Desarrollar una interfaz que permita al usuario ingresar su peso y altura para calcular su Índice de Masa Corporal (IMC) y mostrar la categoría correspondiente (bajo peso, normal, sobrepeso u obesidad).
    
    Características
    Entradas: Campos de texto para ingresar el peso en kilogramos y la altura en centímetros.
    Botón de Cálculo: Un botón para realizar el cálculo del IMC cuando se hace clic.
    Resultado: Muestra el IMC calculado y la categoría correspondiente (bajo peso, normal, sobrepeso u obesidad).
    Botón de Volver: Permite cerrar la actividad actual y volver a la pantalla anterior.
    Lógica de Cálculo
    Convertir la altura de centímetros a metros.
    Usar la fórmula del IMC: IMC = peso / (altura en metros)^2.
    Determinar la categoría del IMC basado en el valor calculado.

2. Conversor de Moneda
    Objetivo
    Crear una interfaz que permita al usuario ingresar una cantidad en pesos chilenos (CLP) y convertirla a varias monedas extranjeras utilizando tasas de conversión predefinidas.
    
    Características
    Entrada: Campo de texto para ingresar la cantidad en CLP.
    Botones para Conversión: Botones para convertir la cantidad a diferentes monedas (USD, EUR, GBP, JPY, CNY, MXN, BRL, CAD, AUD).
    Resultado: Muestra el monto convertido en la moneda seleccionada.
    Botón de Volver: Permite cerrar la actividad actual y volver a la pantalla anterior.
    Lógica de Conversión
    Usar tasas de conversión predefinidas para cada moneda.
    Multiplicar el monto en CLP por la tasa de conversión correspondiente para obtener el monto en la moneda seleccionada.
    Mostrar el resultado con el monto convertido y la moneda correspondiente.
    Aspectos Técnicos Comunes
    Interfaz de Usuario (UI): Ambas actividades usan elementos básicos de la UI de Android como EditText, TextView, y Button.
    Manejo de Eventos: Utilizan OnClickListener para manejar las interacciones del usuario con los botones.
    Validación de Entrada: Verifican si los campos están vacíos y manejan errores de formato para asegurar que el usuario ingrese datos válidos.

