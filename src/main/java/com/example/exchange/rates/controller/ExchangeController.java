package com.example.exchange.rates.controller;

import com.example.exchange.rates.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeController {
    private final ExchangeService exchangeService;

    @GetMapping("/exchange")
    public ExchangeService getExchange(){

        return exchangeService;
    }
}
