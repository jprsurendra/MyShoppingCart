package com.myshoppingcart.currencyconverter.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshoppingcart.currencyconverter.entities.ForexRate;
import com.myshoppingcart.currencyconverter.repositories.ForexRateRepository;

@Service
@Slf4j
public class ForexRateService{

    @Autowired
    private ForexRateRepository forexRateRepository;
}


