package com.book.objects.chap11;

import com.book.objects.chap5.Money;

public interface RatePolicy {

    Money calculateFee(Phone phone);
}
