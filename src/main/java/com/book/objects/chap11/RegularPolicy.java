package com.book.objects.chap11;

import com.book.objects.chap5.Money;

import java.time.Duration;

// 일반 요금제
public class RegularPolicy extends BasicRatePolicy{

    public Money amount;
    private Duration seconds;

    public RegularPolicy(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
