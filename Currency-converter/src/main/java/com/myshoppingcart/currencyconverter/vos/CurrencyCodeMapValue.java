package com.myshoppingcart.currencyconverter.vos;


import com.myshoppingcart.currencyconverter.entities.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyCodeMapValue {
    private Long id;
    private Currency currency;

}
