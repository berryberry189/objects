package com.book.objects.chap5.discount.policy;

import com.book.objects.chap5.Money;
import com.book.objects.chap5.Screening;
import com.book.objects.chap5.discount.condition.DiscountCondition;

/**
 * 비율 할인 정책
 */
public class PercentDiscountPolicy extends DefaultDiscountPolicy {

    //할인 비율
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }

}
