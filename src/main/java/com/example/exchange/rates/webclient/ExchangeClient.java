package com.example.exchange.rates.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExchangeClient {

    private static final String EXCHANGE_URL = "http://api.nbp.pl/api/exchangerates/rates/";
    private RestTemplate restTemplate = new RestTemplate();

    public String getExchangeForCurrency(String code) {
        return restTemplate.getForObject(EXCHANGE_URL + "{table}/{code}/", String.class, "C", code);


    }
}
