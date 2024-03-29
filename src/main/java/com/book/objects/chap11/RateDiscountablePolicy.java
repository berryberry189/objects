package com.book.objects.chap11;

import com.book.objects.chap5.Money;

// 기본 요금 할인 정책
public class RateDiscountablePolicy extends AdditionalRatePolicy{

    private Money discountAmount;

    public RateDiscountablePolicy(Money discountAmount, RatePolicy next) {
        super(next);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
