package com.alura.calculation;

import com.alura.model.Exchange;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConverterCalculations {

    Scanner scanner = new Scanner(System.in);

    public int menu() {
        int option = 0;
        while (true) {
            try {
                System.out.println("""
                    **************************************************************
                    Sea bienvenido al Conversor de Moneda =]
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Salir
                    Elija una opción válida:
                    **************************************************************
                    """);
                option = scanner.nextInt();

                if (option >= 1 && option <= 7) {
                    return option;
                } else {
                    System.out.println("Por favor, elija una opción válida (1-7).\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número del 1 al 7.\n");
                scanner.next();
            }
        }
    }

    public Object[] getData(int option) {
        String base_code;
        String target_code;

        switch (option) {
            case 1 -> {
                base_code = "USD";
                target_code = "ARS";
            }
            case 2 -> {
                base_code = "ARS";
                target_code = "USD";
            }
            case 3 -> {
                base_code = "USD";
                target_code = "BRL";
            }
            case 4 -> {
                base_code = "BRL";
                target_code = "USD";
            }
            case 5 -> {
                base_code = "USD";
                target_code = "COP";
            }
            case 6 -> {
                base_code = "COP";
                target_code = "USD";
            }
            default -> throw new IllegalArgumentException("Opción no válida. Intente de nuevo.");
        }

        double amount = requestAmount();
        return new Object[]{base_code, target_code, amount};
    }

    private double requestAmount() {
        System.out.println("Ingrese el valor que desea convertir: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingrese un valor numérico válido:");
            scanner.next();
        }
        return scanner.nextDouble();
    }
    public void result(Exchange exchange, double amount){
        System.out.println("El valor " + String.format("%.2f", amount) + " [" +exchange.base_code()+ "]" +
                " corresponde al valor de =>>> " + String.format("%.2f", exchange.conversion_result()) + " [" + exchange.target_code() + "]\n\n");
    }
}
