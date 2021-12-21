package com.book.objects.chap11;

import com.book.objects.chap5.Money;

import java.time.Duration;

public class RateDiscountableRegularPhone extends RegularPhone{

    private Money discountAmount;

    public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
        super(amount, seconds);
        this.discountAmount = discountAmount;
    }

    @Override
    public Money afterCalculated(Money fee){
        return fee.minus(discountAmount);
    }
}
