package com.book.objects.chap11;

import com.book.objects.chap5.Money;

// 부가정책
public abstract class AdditionalRatePolicy implements RatePolicy{

    // 조합될 가능성이 있는 다른 요금 정책
    private RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    protected abstract Money afterCalculated(Money fee);
}
