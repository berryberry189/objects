package com.book.objects.chap5.discount.policy;


import com.book.objects.chap5.Money;
import com.book.objects.chap5.Screening;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);

}
