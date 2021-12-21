package com.book.objects.chap11;

import com.book.objects.chap5.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {

    private RatePolicy ratePolicy;

    // 전체 통화 목록
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
                // 테이터 삭제, 추가를 막음
        return Collections.unmodifiableList(calls);
    }

    public Money calculateFee(){
        return ratePolicy.calculateFee(this);
    }

}
