package com.myshoppingcart.currencyconverter.vos;


import com.myshoppingcart.currencyconverter.entities.Currency;
import com.myshoppingcart.currencyconverter.entities.ForexRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversionVO {
    private ForexRateVO forexRateToUSD;
    private ForexRateVO forexRateUSDTo;
    private BigDecimal fromAmount;
    private BigDecimal toAmount;
    private String fromCurrencyCode;
    private String toCurrencyCode;

}
