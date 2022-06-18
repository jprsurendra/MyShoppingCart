package com.myshoppingcart.currencyconverter;

import com.myshoppingcart.currencyconverter.entities.Currency;
import com.myshoppingcart.currencyconverter.entities.ForexRate;
import com.myshoppingcart.currencyconverter.services.CurrencyService;
import com.myshoppingcart.currencyconverter.services.ForexRateService;
import com.myshoppingcart.currencyconverter.vos.CurrencyCodeMapValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class CurrencyConverterApplication implements CommandLineRunner {
	@Autowired
	private CurrencyService currencyService;
	@Autowired
	private ForexRateService forexRateService;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Currency> lstCurrencies = currencyService.create_on_load();

		Map<String, CurrencyCodeMapValue> currencyCodeMap = currencyService.getCountryCodeMap(lstCurrencies);

		List<ForexRate> lstForexRate = forexRateService.refreshForexRateInDB(currencyCodeMap);
	}
}
