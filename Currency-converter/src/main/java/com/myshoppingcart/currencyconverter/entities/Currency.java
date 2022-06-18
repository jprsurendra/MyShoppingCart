package com.myshoppingcart.currencyconverter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String country_name;
    private String country_code;
    private String currency_code;
    private String currency_name;
    private String forex_currency_name;
    private Boolean is_active;

    @Column(name="created_on", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date created_on;

    @Column(name="updated_on", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updated_on;

    public Currency(){}
    public Currency(String country_name, String country_code, String currency_code, String currency_name, String forex_currency_name, Date created_or_updated_on) {
        this(null, country_name, country_code, currency_code, currency_name, forex_currency_name, true, created_or_updated_on, created_or_updated_on);
    }
    public Currency(Long id, String country_name, String country_code, String currency_code, String currency_name, String forex_currency_name, Boolean is_active, Date created_on, Date updated_on) {
        this.id = id;
        this.country_name = country_name;
        this.country_code = country_code;
        this.currency_code = currency_code;
        this.currency_name = currency_name;
        this.forex_currency_name = forex_currency_name;
        this.is_active = is_active;
        this.created_on = created_on;
        this.updated_on = updated_on;
    }
}
