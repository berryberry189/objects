package com.book.objects.chap11;

import com.book.objects.chap5.Money;

// 세금 정책
public class TaxablePolicy extends AdditionalRatePolicy{

    private double taxRatio;

    public TaxablePolicy(double taxRatio, RatePolicy next) {
        super(next);
        taxRatio = taxRatio;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRatio));
    }
}
