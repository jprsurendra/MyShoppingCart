package com.myshoppingcart.currencyconverter.services;

import com.myshoppingcart.currencyconverter.entities.ForexRateBackup;
import com.myshoppingcart.currencyconverter.repositories.ForexRateBackupRepository;
import com.myshoppingcart.currencyconverter.vos.CurrencyCodeMapValue;
import com.myshoppingcart.currencyconverter.vos.CurrencyConversionVO;
import com.myshoppingcart.currencyconverter.vos.ForexRateVO;
import com.myshoppingcart.currencyconverter.vos.ForexRateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshoppingcart.currencyconverter.entities.ForexRate;
import com.myshoppingcart.currencyconverter.repositories.ForexRateRepository;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ForexRateService{

    @Autowired
    private ForexRateRepository forexRateRepository;

    @Autowired
    private ForexRateBackupRepository forexRateBackupRepository;

    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;



    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        System.out.println("ForexRateService setter (setModelMapper) called");
        this.modelMapper = modelMapper;

        /*
        PropertyMap<ForexRate, ForexRateBackup> personMap = new PropertyMap <ForexRate, ForexRateBackup>() {
            protected void configure() {
                map().forex_rate_id(source.id());
            }
        };
        modelMapper.addMappings(personMap);
        */
    }

    public List<ForexRateBackup> create_backup(){
        log.info("Inside create_backup() method of ForexRateService");
        Long id;
        Date created_on = new Date();
        List<ForexRate> allForexRateData = forexRateRepository.findAll();

        // List<ForexRateBackup> allData = allForexRateData.stream().map(post -> modelMapper.map(post, ForexRateBackup.class)).collect(Collectors.toList());
        List<ForexRateBackup> allData = new ArrayList<>();
        for(ForexRate entity : allForexRateData) { // for(ForexRateBackup entity : allData) {
            ForexRateBackup backupEntity = modelMapper.map(entity, ForexRateBackup.class);
            backupEntity.setForex_rate_id(entity.getId());
            backupEntity.setId(null);
            backupEntity.setBackup_on(created_on);
            allData.add(backupEntity);
        }

        return forexRateBackupRepository.saveAll(allData);
    }

    public ForexRate findForexRateByCurrencyCode(String countryCode){
        List<ForexRate> lst = forexRateRepository.findByToCurrency_CurrencyCode(countryCode);
        if(lst.size() > 0){
            return lst.get(0);
        }else{
            return null;
        }
    }



    public List<ForexRate> refreshForexRateInDB(Map<String, CurrencyCodeMapValue> currencyCodeMap) {
        log.info("Inside refreshForexRateInDB() method of ForexRateService");

        List<ForexRateBackup> lst = this.create_backup();

        ForexRateWrapper wrapper = restTemplate.getForObject("https://api.exchangeratesapi.io/v1/latest?access_key=XXXXXXX&base=usd", ForexRateWrapper.class);
        List<ForexRate>  allData = wrapper.toWrap(currencyCodeMap);
        return forexRateRepository.saveAll(allData);
    }

    public List<ForexRate> findAllForexRate(){
        log.info("Inside findAllForexRate() method of ForexRateService");
        return forexRateRepository.findAll();
    }

//    public ForexRate findForexRateByCurrencyCode(String countryCode){
//        log.info("Inside findForexRateByCurrencyCode() method of ForexRateService");
//        List<ForexRate> lst = this.findByCountryCode(countryCode);
//        if(lst.size()>0){
//            return lst.get(0);
//        }else{
//            return null;
//        }
//    }
    public ForexRateVO findForexRateVoByCurrencyCode(String currencyCode){
        ForexRateVO forexRateVO = null;
        try {
            currencyCode = currencyCode.trim().toUpperCase();

            if(currencyCode == "USD"){
                forexRateVO = new ForexRateVO(currencyCode, currencyCode, 1);
            }else{
                forexRateVO = new ForexRateVO(this.findForexRateByCurrencyCode(currencyCode));
            }

            if(forexRateVO == null){
                forexRateVO = new ForexRateVO("USD", currencyCode, BigDecimal.ZERO, BigDecimal.ZERO, "CurrencyCode (" +currencyCode + ") not found.");
            }
        }catch (Exception e){
            if(currencyCode==null){
                currencyCode = "--";
            }
            forexRateVO = new ForexRateVO("USD", currencyCode, BigDecimal.ZERO, BigDecimal.ZERO, "CurrencyCode (" +currencyCode + ") not found.");
        }finally {
            return forexRateVO;
        }
    }

    public CurrencyConversionVO currencyConversion(CurrencyConversionVO vo){
        BigDecimal fromAmount = vo.getFromAmount();
        ForexRateVO forexRateToUSD = this.findForexRateVoByCurrencyCode(vo.getFromCurrencyCode());
        ForexRateVO forexRateUSDTo = this.findForexRateVoByCurrencyCode(vo.getToCurrencyCode());

        BigDecimal amountInUSD = fromAmount.multiply(forexRateToUSD.getReverseConversionRate());
        vo.setToAmount(amountInUSD.multiply(forexRateUSDTo.getConversionRate()));

        vo.setForexRateToUSD(forexRateToUSD);
        vo.setForexRateUSDTo(forexRateUSDTo);

        return vo;
    }
}






/*
    public void create_backup(){
        List<ForexRate> allForexRateData = forexRateRepository.findAll();

        List<ForexRateBackup> allData = allForexRateData.stream().map(post -> modelMapper.map(post, ForexRateBackup.class)).collect(Collectors.toList());
        forexRateBackupRepository.sa

        for(ForexRateBackup entity : allData) {
            activeEntityRepository.save(e);
        }
    }
}

*/
