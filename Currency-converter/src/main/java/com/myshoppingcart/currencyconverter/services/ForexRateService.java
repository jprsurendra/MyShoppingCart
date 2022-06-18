package com.myshoppingcart.currencyconverter.services;

import com.myshoppingcart.currencyconverter.entities.ForexRateBackup;
import com.myshoppingcart.currencyconverter.repositories.ForexRateBackupRepository;
import com.myshoppingcart.currencyconverter.vos.CurrencyCodeMapValue;
import com.myshoppingcart.currencyconverter.vos.ForexRateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshoppingcart.currencyconverter.entities.ForexRate;
import com.myshoppingcart.currencyconverter.repositories.ForexRateRepository;
import org.springframework.web.client.RestTemplate;

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

    public List<ForexRate> refreshForexRateInDB(Map<String, CurrencyCodeMapValue> currencyCodeMap) {
        log.info("Inside refreshForexRateInDB() method of ForexRateService");

        List<ForexRateBackup> lst = this.create_backup();


        ForexRateWrapper wrapper = restTemplate.getForObject("https://api.exchangeratesapi.io/v1/latest?access_key=XXXXXXXXX&base=usd", ForexRateWrapper.class);
        List<ForexRate>  allData = wrapper.toWrap(currencyCodeMap);
        return forexRateRepository.saveAll(allData);
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
