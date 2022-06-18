package com.myshoppingcart.currencyconverter.repositories;

import com.myshoppingcart.currencyconverter.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
