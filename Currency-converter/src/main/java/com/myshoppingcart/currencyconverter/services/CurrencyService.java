package com.myshoppingcart.currencyconverter.services;

import com.myshoppingcart.currencyconverter.entities.Currency;
import com.myshoppingcart.currencyconverter.repositories.CurrencyRepository;
import com.myshoppingcart.currencyconverter.vos.CurrencyCodeMapValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Currency> create_on_load(){
        log.info("Inside create_on_load() method of CurrencyService");

        if(currencyRepository.count() == 0) {
            Date created_on = new Date();
            List<Currency> lstCurrency = new ArrayList<>();

            lstCurrency.add(new Currency("Afghanistan", "AF", "AFN", null, null, created_on));
            lstCurrency.add(new Currency("Albania", "AL", "ALL", null, null, created_on));
            lstCurrency.add(new Currency("Algeria", "DZ", "DZD", null, null, created_on));
            lstCurrency.add(new Currency("Andorra", "AD", "EUR", "Euro", "EroEUR", created_on));
            lstCurrency.add(new Currency("Angola", "AO", "AOA", null, null, created_on));
            lstCurrency.add(new Currency("Anguilla", "AI", "XCD", null, null, created_on));
            lstCurrency.add(new Currency("Argentina", "AR", "ARS", "ArgentinePeso", null, created_on));
            lstCurrency.add(new Currency("Armenia", "AM", "AMD", null, null, created_on));
            lstCurrency.add(new Currency("Aruba", "AW", "AWZ", null, null, created_on));
            lstCurrency.add(new Currency("Aruba", "AW", "AWG", null, null, created_on));
            lstCurrency.add(new Currency("Australia", "AU", "AUD", "Australian Dollar", "Australia DolarAUD", created_on));
            lstCurrency.add(new Currency("Azerbaijan", "AZ", "AZN", null, null, created_on));
            lstCurrency.add(new Currency("Bahamas", "BS", "BSD", null, null, created_on));
            lstCurrency.add(new Currency("Bahrain", "BH", "BHD", "Bahraini Dinar", "Bahraii DiarBHD", created_on));
            lstCurrency.add(new Currency("Bangladesh", "BD", "BDT", "BangladeshiTaka", null, created_on));
            lstCurrency.add(new Currency("Barbados", "BB", "BBD", null, null, created_on));
            lstCurrency.add(new Currency("Belarus", "BY", "BYR", null, null, created_on));
            lstCurrency.add(new Currency("Belarus", "BY", "BYN", null, null, created_on));
            lstCurrency.add(new Currency("Belize", "BZ", "BZD", null, null, created_on));
            lstCurrency.add(new Currency("Bermuda", "BM", "BMD", null, null, created_on));
            lstCurrency.add(new Currency("Bhutan", "BT", "BTN", null, null, created_on));
            lstCurrency.add(new Currency("Bolivia", "BO", "BOB", null, null, created_on));
            lstCurrency.add(new Currency("Bosnia and Herzegovina", "BA", "BAM", null, null, created_on));
            lstCurrency.add(new Currency("Botswana", "BW", "BWP", null, null, created_on));
            lstCurrency.add(new Currency("Brazil", "BR", "BRL", "BrazilianReal", null, created_on));
            lstCurrency.add(new Currency("Brunei Darussalam", "BN", "BND", null, null, created_on));
            lstCurrency.add(new Currency("Bulgaria", "BG", "BGN", null, null, created_on));
            lstCurrency.add(new Currency("Burundi", "BI", "BIF", null, null, created_on));
            lstCurrency.add(new Currency("Cambodia", "KH", "KHR", null, null, created_on));
            lstCurrency.add(new Currency("Canada", "CA", "CAD", "Canadian Dollar", "Canadia DolarCAD", created_on));
            lstCurrency.add(new Currency("Cape Verde", "CV", "CVE", null, null, created_on));
            lstCurrency.add(new Currency("Cayman Islands", "KY", "KYD", null, null, created_on));
            lstCurrency.add(new Currency("Central African Republic", "CF", "XAF", "Center African ranc", null, created_on));
            lstCurrency.add(new Currency("Chile", "CL", "CLP", "ChileanPeso", null, created_on));
            lstCurrency.add(new Currency("Chile", "CL", "CLF", null, null, created_on));
            lstCurrency.add(new Currency("China", "CN", "CNH", "Chinese Yuan", "Chinse YanCNH", created_on));
            lstCurrency.add(new Currency("China", "CN", "CNY", "Chinese Yuan Reninbi", null, created_on));
            lstCurrency.add(new Currency("Colombia", "CO", "COP", "ColombianPeso", null, created_on));
            lstCurrency.add(new Currency("Comoros", "KM", "KMF", null, null, created_on));
            lstCurrency.add(new Currency("Congo", "CD", "CDF", null, null, created_on));
            lstCurrency.add(new Currency("Cook Islands", "CK", "CKD", null, null, created_on));
            lstCurrency.add(new Currency("Costa Rica", "CR", "CRC", "Costa Rican olon", null, created_on));
            lstCurrency.add(new Currency("Croatia", "HR", "HRK", null, null, created_on));
            lstCurrency.add(new Currency("Cuba", "CU", "CUC", null, null, created_on));
            lstCurrency.add(new Currency("Cuba", "CU", "CUP", null, null, created_on));
            lstCurrency.add(new Currency("Curacao", "CW", "ANG", null, null, created_on));
            lstCurrency.add(new Currency("Czech Republic", "CZ", "CZK", null, null, created_on));
            lstCurrency.add(new Currency("Denmark", "DK", "DKK", "Danish Krone", "Danis KroerDKK", created_on));
            lstCurrency.add(new Currency("Djibouti", "DJ", "DJF", null, null, created_on));
            lstCurrency.add(new Currency("Dominica", "DM", "DOP", null, null, created_on));
            lstCurrency.add(new Currency("Egypt", "EG", "EGP", "Egyptian ound", null, created_on));
            lstCurrency.add(new Currency("El Salvador", "SV", "SVC", null, null, created_on));
            lstCurrency.add(new Currency("El Salvador", "SV", "BTC", "Bicoin", null, created_on));
            lstCurrency.add(new Currency("Eritrea", "ER", "ERN", null, null, created_on));
            lstCurrency.add(new Currency("Ethiopia", "ET", "ETB", null, null, created_on));
            lstCurrency.add(new Currency("Fiji", "FJ", "FJD", "Fiji Dllar", null, created_on));
            lstCurrency.add(new Currency("French Polynesia", "PF", "XPF", null, null, created_on));
            lstCurrency.add(new Currency("Gambia", "GM", "GMD", null, null, created_on));
            lstCurrency.add(new Currency("Georgia", "GE", "GEL", null, null, created_on));
            lstCurrency.add(new Currency("Ghana", "GH", "GHS", null, null, created_on));
            lstCurrency.add(new Currency("Gibraltar", "GI", "GIP", null, null, created_on));
            lstCurrency.add(new Currency("Grenada", "GD", "XCD", null, null, created_on));
            lstCurrency.add(new Currency("Guatemala", "GT", "GTQ", null, null, created_on));
            lstCurrency.add(new Currency("Guernsey", "GG", "GGP", null, null, created_on));
            lstCurrency.add(new Currency("Guinea", "GN", "GNF", null, null, created_on));
            lstCurrency.add(new Currency("Guyana", "GY", "GYD", null, null, created_on));
            lstCurrency.add(new Currency("Haiti", "HT", "HTG", null, null, created_on));
            lstCurrency.add(new Currency("Honduras", "HN", "HNL", null, null, created_on));
            lstCurrency.add(new Currency("Hong Kong", "HK", "HKD", "Hong Kong Dollar", "Hong Kog DolaHKD", created_on));
            lstCurrency.add(new Currency("Hungary", "HU", "HUF", null, null, created_on));
            lstCurrency.add(new Currency("Iceland", "IS", "ISK", null, null, created_on));
            lstCurrency.add(new Currency("India", "IN", "INR", "Indian Rupee", "Indanupee", created_on));
            lstCurrency.add(new Currency("Indonesia", "ID", "IDR", "Indonesian Rpiah", null, created_on));
            lstCurrency.add(new Currency("Iran", "IR", "IRR", null, null, created_on));
            lstCurrency.add(new Currency("Iraq", "IQ", "IQD", null, null, created_on));
            lstCurrency.add(new Currency("Isle of Man", "IM", "IMP", null, null, created_on));
            lstCurrency.add(new Currency("Israel", "IL", "ILS", null, null, created_on));
            lstCurrency.add(new Currency("Jamaica", "JM", "JMD", null, null, created_on));
            lstCurrency.add(new Currency("Japan", "JP", "JPY", "Japanese Yen", "Japaese enJPY", created_on));
            lstCurrency.add(new Currency("Jersey", "JE", "JEP", null, null, created_on));
            lstCurrency.add(new Currency("Jordan", "JO", "JOD", null, null, created_on));
            lstCurrency.add(new Currency("Kazakhstan", "KZ", "KZT", null, null, created_on));
            lstCurrency.add(new Currency("Kenya", "KE", "KES", null, null, created_on));
            lstCurrency.add(new Currency("Kuwait", "KW", "KWD", "Kuwaiti Dinar", "Kuwaii DiarKWD", created_on));
            lstCurrency.add(new Currency("Kyrgyzstan", "KG", "KGS", null, null, created_on));
            lstCurrency.add(new Currency("Lao Peoples Democratic Republic", "LA", "LAK", null, null, created_on));
            lstCurrency.add(new Currency("Latvia", "LV", "LVL", null, null, created_on));
            lstCurrency.add(new Currency("Lebanon", "LB", "LBP", null, null, created_on));
            lstCurrency.add(new Currency("Lesotho", "LS", "LSL", null, null, created_on));
            lstCurrency.add(new Currency("Liberia", "LR", "LRD", null, null, created_on));
            lstCurrency.add(new Currency("Libya", "LY", "LYD", null, null, created_on));
            lstCurrency.add(new Currency("Lithuania", "LT", "LTL", null, null, created_on));
            lstCurrency.add(new Currency("Macao", "MO", "MOP", null, null, created_on));
            lstCurrency.add(new Currency("Macedonia", "MK", "MKD", null, null, created_on));
            lstCurrency.add(new Currency("Madagascar", "MG", "MGA", null, null, created_on));
            lstCurrency.add(new Currency("Malawi", "MW", "MWK", null, null, created_on));
            lstCurrency.add(new Currency("Malaysia", "MY", "MYR", "Malaysian Ringgit", "MalaysianRingitMYR", created_on));
            lstCurrency.add(new Currency("Maldives", "MV", "MVR", null, null, created_on));
            lstCurrency.add(new Currency("Mauritania", "MR", "MRO", null, null, created_on));
            lstCurrency.add(new Currency("Mauritania", "MR", "MRU", null, null, created_on));
            lstCurrency.add(new Currency("Mauritius", "MU", "MUR", null, null, created_on));
            lstCurrency.add(new Currency("Mexico", "MX", "MXN", "MexicanPeso", null, created_on));
            lstCurrency.add(new Currency("Moldova", "MD", "MDL", null, null, created_on));
            lstCurrency.add(new Currency("Mongolia", "MN", "MNT", null, null, created_on));
            lstCurrency.add(new Currency("Morocco", "MA", "MAD", "Moroccan Drham", null, created_on));
            lstCurrency.add(new Currency("Mozambique", "MZ", "MZN", null, null, created_on));
            lstCurrency.add(new Currency("Myanmar", "MM", "MMK", null, null, created_on));
            lstCurrency.add(new Currency("Namibia", "NA", "NAD", null, null, created_on));
            lstCurrency.add(new Currency("Nepal", "NP", "NPR", null, null, created_on));
            lstCurrency.add(new Currency("New Zealand", "NZ", "NZD", "New Zealand Dollar", "New Zealad DolaNZD", created_on));
            lstCurrency.add(new Currency("Nicaragua", "NI", "NIO", null, null, created_on));
            lstCurrency.add(new Currency("Nigeria", "NG", "NGN", null, null, created_on));
            lstCurrency.add(new Currency("North Korea", "KP", "KPW", null, null, created_on));
            lstCurrency.add(new Currency("Norway", "NO", "NOK", "Norwegian Kroner", "Norwegia KroerNOK", created_on));
            lstCurrency.add(new Currency("Oman", "OM", "OMR", "Omani Riyal", "Omai RialOMR", created_on));
            lstCurrency.add(new Currency("Pakistan", "PK", "PKR", null, null, created_on));
            lstCurrency.add(new Currency("Panama", "PA", "PAB", null, null, created_on));
            lstCurrency.add(new Currency("Papua New Guinea", "PG", "PGK", "Papua New GuineaKina", null, created_on));
            lstCurrency.add(new Currency("Paraguay", "PY", "PYG", null, null, created_on));
            lstCurrency.add(new Currency("Peru", "PE", "PEN", "Peruvian Nuev Sol", null, created_on));
            lstCurrency.add(new Currency("Philippines", "PH", "PHP", "Philippine Peso", "Philippne PsoPHP", created_on));
            lstCurrency.add(new Currency("Poland", "PL", "PLN", "Polish Zloty", "Polad ZltyPLN", created_on));
            lstCurrency.add(new Currency("Qatar", "QA", "QAR", "Qatari riyal", "Qatai RialQAR", created_on));
            lstCurrency.add(new Currency("Romania", "RO", "RON", null, null, created_on));
            lstCurrency.add(new Currency("Russian Federation", "RU", "RUB", "Russian Rouble", "Russia RouleRUB", created_on));
            lstCurrency.add(new Currency("Rwanda", "RW", "RWF", null, null, created_on));
            lstCurrency.add(new Currency("Saint Helena", "SH", "SHP", null, null, created_on));
            lstCurrency.add(new Currency("Samoa", "WS", "WST", null, null, created_on));
            lstCurrency.add(new Currency("Sao Tome and Principe", "ST", "STD", null, null, created_on));
            lstCurrency.add(new Currency("Saudi Arabia", "SA", "SAR", "Saudi Riyal", "Saui RialSAR", created_on));
            lstCurrency.add(new Currency("Serbia", "RS", "RSD", null, null, created_on));
            lstCurrency.add(new Currency("Seychelles", "SC", "SCR", null, null, created_on));
            lstCurrency.add(new Currency("Sierra Leone", "SL", "SLL", null, null, created_on));
            lstCurrency.add(new Currency("Singapore", "SG", "SGD", "Singapore Dollar", "Singapor DolarSGD", created_on));
            lstCurrency.add(new Currency("Solomon Islands", "SB", "SBD", null, null, created_on));
            lstCurrency.add(new Currency("Somalia", "SO", "SOS", null, null, created_on));
            lstCurrency.add(new Currency("South Africa", "ZA", "ZAR", "South African Rand", "South Afrian RndZAR", created_on));
            lstCurrency.add(new Currency("South Georgia and the South Sandwich Islands", "GS", "FKP", null, null, created_on));
            lstCurrency.add(new Currency("South Korea", "KR", "KRW", "South-Korean Won", "Koean onKRW", created_on));
            lstCurrency.add(new Currency("Sri Lanka", "LK", "LKR", "Sri Lankan upee", null, created_on));
            lstCurrency.add(new Currency("Sudan", "SD", "SDG", "Sudanese ound", null, created_on));
            lstCurrency.add(new Currency("Suriname", "SR", "SRD", null, null, created_on));
            lstCurrency.add(new Currency("Swaziland", "SZ", "SZL", null, null, created_on));
            lstCurrency.add(new Currency("Sweden", "SE", "SEK", "Swedish Krona", "Swedis KroorSEK", created_on));
            lstCurrency.add(new Currency("Switzerland", "CH", "CHF", "Swiss Franc", "Swis FrncCHF", created_on));
            lstCurrency.add(new Currency("Syrian Arab Republic", "SY", "SYP", null, null, created_on));
            lstCurrency.add(new Currency("Taiwan", "TW", "TWD", "Taiwan Dllar", null, created_on));
            lstCurrency.add(new Currency("Tajikistan", "TJ", "TJS", null, null, created_on));
            lstCurrency.add(new Currency("Tanzania", "TZ", "TZS", null, null, created_on));
            lstCurrency.add(new Currency("Thailand", "TH", "THB", "Thai Baht", "Tai BhtTHB", created_on));
            lstCurrency.add(new Currency("Tonga", "TO", "TOP", null, null, created_on));
            lstCurrency.add(new Currency("Trinidad and Tobago", "TT", "TTD", null, null, created_on));
            lstCurrency.add(new Currency("Tunisia", "TN", "TND", null, null, created_on));
            lstCurrency.add(new Currency("Turkey", "TR", "TRY", "TurkishLira", null, created_on));
            lstCurrency.add(new Currency("Turkmenistan", "TM", "TMT", null, null, created_on));
            lstCurrency.add(new Currency("Tuvalu", "TV", "TVD", null, null, created_on));
            lstCurrency.add(new Currency("Uganda", "UG", "UGX", null, null, created_on));
            lstCurrency.add(new Currency("Ukraine", "UA", "UAH", null, null, created_on));
            lstCurrency.add(new Currency("United Arab Emirates (UAE)", "AE", "AED", "Utd. Arab Emir. Dirham", "U.A. DiramAED", created_on));
            lstCurrency.add(new Currency("United Kingdom (UK)", "GB", "GBP", "British Pound", "Great Britan PondGBP", created_on));
            lstCurrency.add(new Currency("United States of America (USA)", "US", "USD", "U.S Dollar", "United State DolarUSD", created_on));
            lstCurrency.add(new Currency("Uruguay", "UY", "UYU", "UruguayanPeso", null, created_on));
            lstCurrency.add(new Currency("Uzbekistan", "UZ", "UAH", null, null, created_on));
            lstCurrency.add(new Currency("Uzbekistan", "UZ", "UZS", null, null, created_on));
            lstCurrency.add(new Currency("Vanuatu", "VU", "VUV", null, null, created_on));
            lstCurrency.add(new Currency("Venezuela", "VE", "VEF", null, null, created_on));
            lstCurrency.add(new Currency("Venezuela", "VE", "VEB", null, null, created_on));
            lstCurrency.add(new Currency("Vietnam", "VN", "VND", "VietnameseDong", null, created_on));
            lstCurrency.add(new Currency("West Africa", "CF", "XOF", "West African ranc", null, created_on));
            lstCurrency.add(new Currency("Yemen", "YE", "YER", null, null, created_on));
            lstCurrency.add(new Currency("Zambia", "ZM", "ZMK", null, null, created_on));
            lstCurrency.add(new Currency("Zambia", "ZM", "ZMW", null, null, created_on));
            lstCurrency.add(new Currency("Zimbabwe", "ZW", "ZWL", null, null, created_on));

            return currencyRepository.saveAll(lstCurrency);
        }else{
            return currencyRepository.findAll();
        }

    }

    public Map<String, CurrencyCodeMapValue> getCountryCodeMap(List<Currency> lstCurrencies){
        log.info("Inside getCountryCodeMap() method of CurrencyService");

        Map<String, CurrencyCodeMapValue> map = new HashMap<>();
        if(lstCurrencies==null){
            lstCurrencies = currencyRepository.findAll();
        }
        for (Currency currency : lstCurrencies ) {
            map.put(currency.getCurrencyCode().toUpperCase(), new CurrencyCodeMapValue(currency.getId(), currency));
        }
        return map;
    }
}


