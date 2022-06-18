package com.myshoppingcart.currencyconverter.repositories;

import com.myshoppingcart.currencyconverter.entities.ForexRateBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForexRateBackupRepository extends JpaRepository<ForexRateBackup, Long> {
}
