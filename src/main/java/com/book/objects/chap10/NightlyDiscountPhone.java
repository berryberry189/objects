package com.book.objects.chap10;

import com.book.objects.chap5.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// 심야 할인 요금제
public class NightlyDiscountPhone extends AbstractPhone{
    private static final int LATE_NIGHT_HOUR = 22;

    // 심야 할인 요금
    private final Money nightlyAmount;
    // 일반 요금
    private final Money regularAmount;
    // 단위 시간(초)
    private final Duration seconds;
    // 통화 목록
    private final List<Call> calls = new ArrayList<>();

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    @Override
    protected Money calculateCallFee(Call call){
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }else {
            return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }
    }
}
