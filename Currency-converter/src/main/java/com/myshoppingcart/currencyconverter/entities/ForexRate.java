package com.myshoppingcart.currencyconverter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "forex_rate")
public class ForexRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "base_currency_id")
    private Currency baseCurrency;

    @OneToOne
    @JoinColumn(name = "to_currency_id")
    private Currency toCurrency;

    @Column(name = "conversion_rate", precision = 25, scale = 6)
    private BigDecimal conversionRate;

    @Column(name="updated_on", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updatedOn;

    private Boolean isActive;

}
