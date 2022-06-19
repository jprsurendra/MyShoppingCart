package com.myshoppingcart.currencyconverter.vos;


import com.myshoppingcart.currencyconverter.entities.Currency;
import com.myshoppingcart.currencyconverter.entities.ForexRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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

    public List<String> collectErrors(){
        List<String> errs = new ArrayList<>();

        if(toAmount == null){
            errs.add("Currency conversion failed! There was an error on server. Please try again.");
        }

        if(forexRateToUSD!=null && forexRateToUSD.getErrMessage() != null){
            errs.add(forexRateToUSD.getErrMessage());
        }

        if(forexRateUSDTo!=null && forexRateUSDTo.getErrMessage() != null){
            errs.add(forexRateUSDTo.getErrMessage());
        }

        return errs;
    }

}
