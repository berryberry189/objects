package com.book.objects.chap5.discount.policy;

import com.book.objects.chap5.Money;
import com.book.objects.chap5.Screening;
import com.book.objects.chap5.discount.condition.DiscountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 할인 정책
 */
public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    //서브 클래스에게 위임(TEMPLATE METHOD 패턴)
    abstract protected Money getDiscountAmount(Screening screening);

}
