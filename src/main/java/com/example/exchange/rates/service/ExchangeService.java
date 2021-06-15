package com.example.exchange.rates.service;

import com.example.exchange.rates.ExchangeRates;
import com.example.exchange.rates.webclient.ExchangeClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class ExchangeService {

    private final ExchangeClient exchangeClient;

    @SneakyThrows
    public String getExchange() {
        String response = exchangeClient.getExchangeForCurrency("EUR");
        log.info(response);

        ObjectMapper mapper = new ObjectMapper();
        ExchangeRates kurs = mapper.readValue(response, ExchangeRates.class);
        System.out.println(kurs.getCurrency());
        System.out.println(kurs.getCode());
        System.out.println(kurs.getRates().get(0).getBid());
        String currency = kurs.getCurrency();
        String code = kurs.getCode();
        Double bid = kurs.getRates().get(0).getBid();


        return kurs.getCurrency() + "\n" + kurs.getCode() + "\n" + kurs.getRates().get(0).getBid();
    }
}