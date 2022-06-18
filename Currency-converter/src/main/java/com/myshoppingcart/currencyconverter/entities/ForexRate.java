package com.myshoppingcart.currencyconverter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

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
    @JoinColumn(name = "base_country_id")
    private Currency base_country;

    @OneToOne
    @JoinColumn(name = "to_country_id")
    private Currency to_country;

    @Column(name = "conversion_rate", precision = 25, scale = 6)
    private BigDecimal conversion_rate;

    @Column(name = "without_uplift_conversion_rate", precision = 25, scale = 6)
    private BigDecimal without_uplift_conversion_rate;

    @Column(name="updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updated_on;

    //    @Column(columnDefinition="bit default 0")
    private Boolean is_active;


}
