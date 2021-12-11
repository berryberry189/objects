package com.book.objects.chap5.discount;

import com.book.objects.chap5.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {

    /**
     * 해당 클래스는 하나 이상의 변경 이유르르 가지기 때문에 응집도가 낮다.
     * 응집도가 낮다 => 연관성이 없는 기능이나 데이터가 하나의 클래스 안에 뭉쳐져 있다는 것을 의미
     * 해결책 : 변경의 이유에 따라 클래스를 분리해야 한다.
     *        함께 초기화 되는 속성을 기준으로 코드를 분리하
     *
     *   분리한 코드 discount > condition 패키지
     *
     */

    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isSatisfiedBy(Screening screening) {
        if(type == DiscountConditionType.PERIOD){
            return isSatisfiedByPeriod(screening);
        }
        return isSatisfiedBySequence(screening);
    }

    private boolean isSatisfiedByPeriod(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }

    private boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }
}
