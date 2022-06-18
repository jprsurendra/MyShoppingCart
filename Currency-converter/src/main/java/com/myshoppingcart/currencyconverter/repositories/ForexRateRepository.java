package com.myshoppingcart.currencyconverter.repositories;

import com.myshoppingcart.currencyconverter.entities.ForexRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForexRateRepository extends JpaRepository<ForexRate, Long> {
}
