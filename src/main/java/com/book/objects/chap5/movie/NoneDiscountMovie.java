package com.book.objects.chap5.movie;

import com.book.objects.chap5.Money;

import java.time.Duration;

public class NoneDiscountMovie extends Movie{

    public NoneDiscountMovie(String title, Duration runningTime, Money fee) {
        super(title, runningTime, fee);
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
