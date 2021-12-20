package com.book.objects.chap11;

import com.book.objects.chap5.Money;

import java.time.Duration;

public class TaxableNightlyDiscountPhone extends NightlyDiscountPhone{

    private double taxRate;

    public TaxableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
        super(nightlyAmount, regularAmount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    public Money afterCalculated(Money fee){
        return fee.plus(fee.times(taxRate));
    }
}
