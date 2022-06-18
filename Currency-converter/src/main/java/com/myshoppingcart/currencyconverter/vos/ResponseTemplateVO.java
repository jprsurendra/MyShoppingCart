package com.myshoppingcart.currencyconverter.vos;


import com.myshoppingcart.currencyconverter.entities.ForexRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private ForexRate forexRate;

}
