package com.book.objects.chap5.movie;

import com.book.objects.chap5.Money;
import com.book.objects.chap5.Screening;
import com.book.objects.chap5.discount.condition.DiscountCondition;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening){
        if( isDiscountable(screening)){
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    // 할인 여부 판단
    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(c -> c.isSatisfiedBy(screening));
    }

    abstract protected Money calculateDiscountAmount();

}
