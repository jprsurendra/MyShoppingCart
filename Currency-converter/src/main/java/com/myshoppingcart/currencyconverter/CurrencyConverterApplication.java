package com.myshoppingcart.currencyconverter;

import com.myshoppingcart.currencyconverter.entities.Currency;
import com.myshoppingcart.currencyconverter.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CurrencyConverterApplication implements CommandLineRunner {
	@Autowired
	private CurrencyService currencyService;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Currency> lst = currencyService.create_on_load();

	}
}
