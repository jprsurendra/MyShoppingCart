package com.myshoppingcart.currencyconverter.services;

import com.myshoppingcart.currencyconverter.entities.ForexRateBackup;
import com.myshoppingcart.currencyconverter.repositories.ForexRateBackupRepository;
import com.myshoppingcart.currencyconverter.vos.CurrencyCodeMapValue;
import com.myshoppingcart.currencyconverter.vos.ForexRateWrapper;
import com.myshoppingcart.currencyconverter.vos.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshoppingcart.currencyconverter.entities.ForexRate;
import com.myshoppingcart.currencyconverter.repositories.ForexRateRepository;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Long id;
        Date created_on = new Date();

        List<ForexRate> allForexRateData = forexRateRepository.findAll();

        List<ForexRateBackup> allData = allForexRateData.stream().map(post -> modelMapper.map(post, ForexRateBackup.class)).collect(Collectors.toList());

        for(ForexRateBackup entity : allData) {
            entity.setForex_rate_id(entity.getId());
            entity.setId(null);
            entity.setBackup_on(created_on);
        }

        return forexRateBackupRepository.saveAll(allData);
    }

    public List<ForexRate> refreshForexRateInDB(Map<String, CurrencyCodeMapValue> currencyCodeMap) {
        log.info("Inside getUserWithDepartment of ForexRateService");

        ForexRateWrapper wrapper = restTemplate.getForObject("https://api.exchangeratesapi.io/v1/latest?access_key=XXXXXXXXXXXXXXXXXXXXXX&base=usd", ForexRateWrapper.class);
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
