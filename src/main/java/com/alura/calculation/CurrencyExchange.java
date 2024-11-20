package com.alura.calculation;

import com.alura.model.Exchange;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyExchange {
    public Exchange currencyExchangeSearch(String base_code,
                                           String target_code,
                                           double amount){
        URI address = URI.create("https://v6.exchangerate-api.com/v6/285a8fc1c050326ace5e8173/pair/" +
                base_code + "/" + target_code + "/" + amount);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Exchange.class);
        }catch (Exception e){
            throw new RuntimeException("No se pudo hacer la conversión: "+ e.getMessage());
        }
    }
}
