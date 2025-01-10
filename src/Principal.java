import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        consultaApi conApi = new consultaApi();

        int opcion = 0;
        float valorACovertir;
        float ValorConvertido;
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

            System.out.println("Ingrese el valor que desea convertir:");
            valorACovertir = input.nextFloat();
            switch (opcion) {
                case 1:
                    System.out.println("Dolar -> Peso Argentino");
                    break;
                case 2:
                    System.out.println("Peso Argentino -> Dolar");
                    break;
                case 3:
                    System.out.println("Dolar -> Real Brasileño");
                    break;
                case 4:
                    System.out.println("Real Brasileño -> Dolar");
                    break;
                case 5:
                    System.out.println("Dolar -> Peso Colombiano");
                    break;
                case 6:
                    System.out.println("Peso Colombiano -> Dolar");
                    break;
                case 7:
                    System.out.println("Gracias por Visitarnos, te esperamos pronto");
                    break;

                default:
                    System.out.println("Opcion no Valida");

            }
        }while(opcion != 7);
    }
}
