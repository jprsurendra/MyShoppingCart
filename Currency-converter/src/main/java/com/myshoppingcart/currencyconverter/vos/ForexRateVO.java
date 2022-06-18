package com.myshoppingcart.currencyconverter.vos;

import com.myshoppingcart.currencyconverter.entities.Currency;
import com.myshoppingcart.currencyconverter.entities.ForexRate;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ForexRateVO {
    private String baseCurrencyCode;
    private String toCurrencyCode;
    private BigDecimal conversionRate;
    private BigDecimal reverseConversionRate;

    private String errMessage="";

    public ForexRateVO(){}

    public ForexRateVO(String baseCurrencyCode, String toCurrencyCode, Integer conversionRate){
        this.reset(baseCurrencyCode, toCurrencyCode, new BigDecimal(conversionRate));
    }
    public ForexRateVO(String baseCurrencyCode, String toCurrencyCode, BigDecimal conversionRate){
        this.reset(baseCurrencyCode, toCurrencyCode, conversionRate);
    }

    public ForexRateVO(String baseCurrencyCode, String toCurrencyCode, BigDecimal conversionRate, BigDecimal reverseConversionRate, String errMessage) {
        this.baseCurrencyCode = baseCurrencyCode;
        this.toCurrencyCode = toCurrencyCode;
        this.conversionRate = conversionRate;
        this.reverseConversionRate = reverseConversionRate;
        this.errMessage = errMessage;
    }

    public ForexRateVO(ForexRate forexRate) {
        try {
            this.reset(forexRate.getBaseCurrency().getCurrencyCode(), forexRate.getToCurrency().getCurrencyCode(), forexRate.getConversionRate());
        }catch (Exception e){
            errMessage = e.getMessage();
        }
    }
    public void reset(String baseCurrencyCode, String toCurrencyCode, BigDecimal conversionRate) {
        this.baseCurrencyCode = baseCurrencyCode;
        this.toCurrencyCode = toCurrencyCode;
        this.conversionRate = conversionRate;
        BigDecimal one = new BigDecimal(1);
        this.reverseConversionRate = one.divide(this.conversionRate);
        this.errMessage="";
    }



}
