package com.myshoppingcart.currencyconverter.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "country_name", length = 255)
    private String countryName;
    @Column(name = "country_code", length = 10)
    private String countryCode;
    @Column(name = "currency_code", length = 10)
    private String currencyCode;
    @Column(name = "currency_name", length = 255)
    private String currencyName;
    @Column(name = "forex_currency_name", length = 255)
    private String forexCurrencyName;
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name="created_on", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdOn;

    @Column(name="updated_on", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updatedOn;

    public Currency(){}
    public Currency(String countryName, String countryCode, String currencyCode, String currencyName, String forexCurrencyName, Date createdOrUpdatedOn) {
        this(null, countryName, countryCode, currencyCode, currencyName, forexCurrencyName, true, createdOrUpdatedOn, createdOrUpdatedOn);
    }

    public Currency(Long id, String countryName, String countryCode, String currencyCode, String currencyName, String forexCurrencyName, Boolean isActive, Date createdOn, Date updatedOn) {
        this.id = id;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.forexCurrencyName = forexCurrencyName;
        this.isActive = isActive;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }
}
