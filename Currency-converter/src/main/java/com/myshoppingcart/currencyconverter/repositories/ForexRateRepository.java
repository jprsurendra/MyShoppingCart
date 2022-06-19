package com.myshoppingcart.currencyconverter.repositories;

import com.myshoppingcart.currencyconverter.entities.ForexRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForexRateRepository extends JpaRepository<ForexRate, Long> {
    //findByNameAndLocation(String name, String location)
    //findByNameOrLocation(String name, String location)
    // public List<ForexRate> findBytoCurrency(String name);
//    @Query("SELECT fx FROM ForexRate fx WHERE fx.toCurrency IN (SELECT c FROM Currency c WHERE LOWER(c.countryCode) = LOWER(:countryCode)) ")
//    List<ForexRate> getByCountryCode(String countryCode);
    List<ForexRate> findByToCurrency_CurrencyCode(String countryCode);
    List<ForexRate> findByIsActiveAndToCurrency_CurrencyCode(Boolean isActive, String countryCode);
}
