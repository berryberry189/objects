package com.book.objects.chap11;

import com.book.objects.chap5.Money;

import java.time.Duration;

public class TaxableRegularPhone extends RegularPhone{

    private double taxRate;

    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    public Money afterCalculated(Money fee){
     return fee.plus(fee.times(taxRate));
    }
}
