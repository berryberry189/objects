package com.book.objects.chap10;

import com.book.objects.chap5.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RegularPhone extends Phone {
    // 단위 요금
    private Money amount;
    // 단위 시간
    private Duration seconds;
    // 전체 통화 목록
    private List<Call> calls = new ArrayList<>();

    public RegularPhone(Money amount, Duration seconds) {
        super(0);
        this.amount = amount;
        this.seconds = seconds;
    }

    public RegularPhone(Money amount, Duration seconds, double taxRate) {
        super(taxRate);
        this.amount = amount;
        this.seconds = seconds;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }

}
