package com.book.objects.chap5.discount.condition;

import com.book.objects.chap5.Screening;

/**
 * 할인 조건
 */
public interface DiscountCondition {

    // 역할만 정의
    boolean isSatisfiedBy(Screening screening);

    /**
     * SequenceCondition, PeriodCondition 로 캡슐화 한 상태
     * 새로운 할인 조건이 추가 된다면 Movie를 수정할 필요없이 DiscountCondition의 구현체를 추가하면 된다.
     */

}
