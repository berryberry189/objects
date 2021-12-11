package com.book.objects.chap5.discount.condition;

import com.book.objects.chap5.Screening;

/**
 * 할인 조건 - 순번 조건
 */
public class SequenceCondition implements DiscountCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }

}
