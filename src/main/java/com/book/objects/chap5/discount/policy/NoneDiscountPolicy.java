package com.book.objects.chap5.discount.policy;

import com.book.objects.chap5.Money;
import com.book.objects.chap5.Screening;

/**
 * 할인 정책 미적용
 */
public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
