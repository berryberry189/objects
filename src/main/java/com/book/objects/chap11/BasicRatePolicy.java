package com.book.objects.chap11;

import com.book.objects.chap5.Money;

// 기본정책
public abstract class BasicRatePolicy implements RatePolicy {

    @Override
    public Money calculateFee(Phone phone){
        Money result = Money.ZERO;
        for(Call call : phone.getCalls()){
            result.plus(calculateCallFee(call));
        }
        return result;
    }

    protected abstract Money calculateCallFee(Call call);
}
