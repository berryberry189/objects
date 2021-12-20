package com.book.objects.chap11;

import com.book.objects.chap5.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// 심야 할인 요금제
public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    // 심야 할인 요금
    private final Money nightlyAmount;
    // 일반 요금
    private final Money regularAmount;
    // 단위 시간(초)
    private final Duration seconds;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call){
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }else {
            return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee;
    }
}
