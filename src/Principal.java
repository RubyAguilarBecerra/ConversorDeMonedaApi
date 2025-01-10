import com.google.gson.JsonObject;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        consultaApi conApi = new consultaApi();

        int opcion = 0;
        float valorACovertir;
        double valorConvertido;

        do {
            System.out.println("""
                    ****************************
                    BIENVENIDO/A AL CONVERSOR DE MONEDA
                    1. Dolar -> Peso Argentino
                    2. Peso Argentino -> Dolar
                    3. Dolar -> Real Brasileño
                    4. Real Brasileño -> Dolar
                    5. Dolar -> Peso Colombiano
                    6. Peso Colombiano -> Dolar
                    7. Salir
                    Elija una opción valida:
                    ****************************
                    """);
            opcion = input.nextInt();

            if (opcion == 7) {
                System.out.println("Gracias por Visitarnos, te esperamos pronto");
                break;
            }

            System.out.println("Ingrese el valor que desea convertir:");
            valorACovertir = input.nextFloat();

            switch (opcion) {
                case 1: // Dólar -> Peso Argentino
                    System.out.println("Dolar -> Peso Argentino");
                    valorConvertido = convertirMoneda("USD", "ARS", valorACovertir, conApi);
                    System.out.println("Resultado: " + valorACovertir + " USD = " + valorConvertido + " ARS");
                    break;

                case 2: // Peso Argentino -> Dólar
                    System.out.println("Peso Argentino -> Dolar");
                    valorConvertido = convertirMoneda("ARS", "USD", valorACovertir, conApi);
                    System.out.println("Resultado: " + valorACovertir + " ARS = " + valorConvertido + " USD");
                    break;

                case 3: // Dólar -> Real Brasileño
                    System.out.println("Dolar -> Real Brasileño");
                    valorConvertido = convertirMoneda("USD", "BRL", valorACovertir, conApi);
                    System.out.println("Resultado: " + valorACovertir + " USD = " + valorConvertido + " BRL");
                    break;

                case 4: // Real Brasileño -> Dólar
                    System.out.println("Real Brasileño -> Dolar");
                    valorConvertido = convertirMoneda("BRL", "USD", valorACovertir, conApi);
                    System.out.println("Resultado: " + valorACovertir + " BRL = " + valorConvertido + " USD");
                    break;

                case 5: // Dólar -> Peso Colombiano
                    System.out.println("Dolar -> Peso Colombiano");
                    valorConvertido = convertirMoneda("USD", "COP", valorACovertir, conApi);
                    System.out.println("Resultado: " + valorACovertir + " USD = " + valorConvertido + " COP");
                    break;

                case 6: // Peso Colombiano -> Dólar
                    System.out.println("Peso Colombiano -> Dolar");
                    valorConvertido = convertirMoneda("COP", "USD", valorACovertir, conApi);
                    System.out.println("Resultado: " + valorACovertir + " COP = " + valorConvertido + " USD");
                    break;

                default:
                    System.out.println("Opcion no Valida");
            }
        } while (opcion != 7);
    }

    // Método para convertir monedas, recibe el tipo de moneda de origen, destino y el valor
    public static double convertirMoneda(String monedaOrigen, String monedaDestino, float valorACovertir, consultaApi conApi) {
        Moneda moneda = conApi.consultaMoneda(monedaOrigen);  // Obtenemos la tasa de cambio
        double tasaCambio = obtenerTasa(moneda, monedaDestino);  // Obtenemos la tasa para la moneda de destino
        if (tasaCambio == -1) {
            System.out.println("No se encontró la tasa de cambio para " + monedaDestino);
            return 0;
        }
        return valorACovertir * tasaCambio;  // Realizamos la conversión
    }

    // Método para obtener la tasa de cambio de la moneda
    public static double obtenerTasa(Moneda moneda, String monedaDestino) {
        JsonObject conversionRates = moneda.conversion_rates();
        if (conversionRates.has(monedaDestino)) {
            return conversionRates.get(monedaDestino).getAsDouble();  // Cambié a getAsDouble()
        }
        return -1;  // Retorna -1 si no se encuentra la tasa de cambio
    }
}
