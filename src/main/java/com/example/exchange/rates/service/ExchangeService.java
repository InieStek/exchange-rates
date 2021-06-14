package com.example.exchange.rates.service;

import com.example.exchange.rates.webclient.ExchangeClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeClient exchangeClient;

    public String getExchange() {
        String response = exchangeClient.getExchangeForCurrency("EUR");
        log.info(response);
        return response;
    }
}