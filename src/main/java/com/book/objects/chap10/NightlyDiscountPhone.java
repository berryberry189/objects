package com.book.objects.chap10;

import com.book.objects.chap5.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// 심야 할인 요금제
public class NightlyDiscountPhone {
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

    //심야 요금을 고려한 통화 요금 계산
    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(
                        nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }else {
                result = result.plus(
                        regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }
        }

        return result;
    }
}
