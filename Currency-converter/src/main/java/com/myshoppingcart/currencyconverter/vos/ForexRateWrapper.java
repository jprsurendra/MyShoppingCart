package com.myshoppingcart.currencyconverter.vos;

import com.myshoppingcart.currencyconverter.entities.Currency;
import com.myshoppingcart.currencyconverter.entities.ForexRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForexRateWrapper {
    private Boolean success; // true
    private Long timestamp; // 1655554755
    private String base;    // "USD"
    private String date;    // "2022-06-18",
    private HashMap<String, String> rates; // { "AED": 3.673104, "AFN": 89.437089,.... }


    public List<ForexRate> toWrap(Map<String, CurrencyCodeMapValue> currencyCodeMap){
        List<ForexRate> lst = new ArrayList<>();
        try {
            Currency baseCurrency = currencyCodeMap.get(this.base.toUpperCase()).getCurrency();
            Date created_on = new Date();

            for (Map.Entry<String,String> entry : this.rates.entrySet()) {
                try {
                    ForexRate entity = new ForexRate();
                    entity.setBaseCurrency(baseCurrency);
                    entity.setToCurrency(currencyCodeMap.get(entry.getKey().toUpperCase()).getCurrency());
                    entity.setConversionRate(new BigDecimal(entry.getValue())); // 3.673104
                    entity.setIsActive(true);
                    entity.setUpdatedOn(created_on);
                    lst.add(entity);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }catch (Exception e2){
            System.out.println(e2.getMessage());
        }
        return lst;
    }

}
