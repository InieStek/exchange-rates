package com.example.exchange.rates.service;

import com.example.exchange.rates.domain.ExchangeRates;
import com.example.exchange.rates.webclient.ExchangeClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class ExchangeService {

    private final ExchangeClient exchangeClient;

    public String getExchange() throws JsonProcessingException {
        String response = exchangeClient.getExchangeForCurrency("EUR");
        ObjectMapper mapper = new ObjectMapper();
        ExchangeRates exchange = mapper.readValue(response, ExchangeRates.class);
        log.info(exchange.getCurrency() + "\n" + exchange.getCode() + "\n" + exchange.getRates().get(0).getBid());
        return null;
    }
}