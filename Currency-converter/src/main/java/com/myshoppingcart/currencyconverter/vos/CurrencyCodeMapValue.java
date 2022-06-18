package com.myshoppingcart.currencyconverter.vos;


import com.myshoppingcart.currencyconverter.entities.Currency;
import com.myshoppingcart.currencyconverter.entities.ForexRate;
import com.myshoppingcart.currencyconverter.services.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyCodeMapValue {
    private Long id;
    private Currency currency;

}
