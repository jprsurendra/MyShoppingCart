package com.myshoppingcart.currencyconverter.web;

import com.myshoppingcart.currencyconverter.entities.*;
import com.myshoppingcart.currencyconverter.services.*;

import com.myshoppingcart.currencyconverter.vos.CurrencyConversionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class ForexRateController {
    @Autowired
    private ForexRateService forexRateService;



    @GetMapping("forex-rate/")
    public List< ForexRate > findAllForexRate() {
        log.info("Inside findAllForexRate method of ForexRateController");
        return forexRateService.findAllForexRate();
    }

    @GetMapping("forex-rate/{currencyCode}")
    public ForexRate findForexRateByCurrencyCode(@PathVariable("currencyCode") String currencyCode) {
        log.info("Inside findForexRateById method of ForexRateController");
        return forexRateService.findForexRateByCurrencyCode(currencyCode);
    }

    @GetMapping("currency-conversion/{currencyCodeFrom}/{currencyCodeTo}/{amount}")
    public CurrencyConversionVO currencyConversion(@PathVariable("currencyCodeFrom") String currencyCodeFrom, @PathVariable("currencyCodeTo") String currencyCodeTo, @PathVariable("amount") BigDecimal amount) {
        log.info("Inside findForexRateById method of ForexRateController");
        CurrencyConversionVO vo = new CurrencyConversionVO();
        vo.setFromCurrencyCode(currencyCodeFrom);
        vo.setToCurrencyCode(currencyCodeTo);
        vo.setFromAmount(amount);
        return forexRateService.currencyConversion(vo);
    }
}
