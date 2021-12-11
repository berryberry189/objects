package com.book.objects.chap5.movie;

import com.book.objects.chap5.Money;
import com.book.objects.chap5.discount.condition.DiscountCondition;

import java.time.Duration;

public class AmountDiscountMovie extends Movie{

    private Money discountMoney;

    public AmountDiscountMovie(String title, Duration runningTime, Money fee,
                               Money discountMoney, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountMoney = discountMoney;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountMoney;
    }
}
