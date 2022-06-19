package com.myshoppingcart.currencyconverter.controller;

import com.myshoppingcart.currencyconverter.entities.*;
import com.myshoppingcart.currencyconverter.services.*;

import com.myshoppingcart.currencyconverter.vos.CurrencyConversionVO;
import com.myshoppingcart.currencyconverter.vos.ResponseWrapper;
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
    public ResponseWrapper currencyConversion(@PathVariable("currencyCodeFrom") String currencyCodeFrom, @PathVariable("currencyCodeTo") String currencyCodeTo, @PathVariable("amount") BigDecimal amount) {
        CurrencyConversionVO vo = new CurrencyConversionVO();
        Boolean status = Boolean.TRUE;
        Integer response_code = ResponseWrapper.INTERNAL_WARNING_1004_DATA_NOT_FOUND;
        String response_message = null;
        try {
            log.info("Inside findForexRateById method of ForexRateController");
            vo.setFromCurrencyCode(currencyCodeFrom);
            vo.setToCurrencyCode(currencyCodeTo);
            vo.setFromAmount(amount);
            vo = forexRateService.currencyConversion(vo);
            if(vo.getToAmount()!=null) {
                response_code = ResponseWrapper.INTERNAL_NO_ERROR_1001_SUCCESSFULLY_DONE;
                response_message = "Currency conversion successfully done, No error found.";
            }else{
                response_message = "Currency conversion failed! Conversion data not found.";
            }
        }catch (Exception e){
            log.info("Inside findForexRateById method of ForexRateController Error: " + e.getMessage());
            status = Boolean.FALSE;
            response_code = ResponseWrapper.INTERNAL_WARNING_1005_DATA_NOT_FOUND;
            response_message = "Currency conversion failed! There was an error on server. Please try again.";
        }finally {
            return new ResponseWrapper(status, 200, response_code, response_message, vo, vo.collectErrors());
        }
    }
}
