package com.alura.main;

import com.alura.calculation.ConverterCalculations;
import com.alura.calculation.CurrencyExchange;
import com.alura.model.Exchange;

public class Main {
    public static void main(String[] args) {
        ConverterCalculations calc = new ConverterCalculations();
        CurrencyExchange curr = new CurrencyExchange();
        boolean flag = true;

        while(flag){
            try {
                int option = calc.menu();

                if (option != 7) {
                    Object[] results = calc.getData(option);
                    String base_code = (String) results[0];
                    String target_code = (String) results[1];
                    double amount = (double) results[2];
                    Exchange exchange = curr.currencyExchangeSearch(base_code, target_code, amount);
                    calc.result(exchange, amount);
                } else {
                    flag = false;
                    System.out.println("¡Gracias por usar el conversor de monedas! Hasta pronto.");
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }
}