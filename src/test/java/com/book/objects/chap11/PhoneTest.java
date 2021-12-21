package com.book.objects.chap11;

import com.book.objects.chap5.Money;

import java.time.Duration;

class PhoneTest {

    // 일반 요금제의 규칙에 따라 통화 요금을 계산하는 전화
    Phone regularPolicyPhone() {
        return new Phone(
                new RegularPolicy(
                        Money.wons(10),
                        Duration.ofSeconds(10)));
    }

    // 심야 할인 요금제의 규칙에 따라 통화 요금을 계산하는 전화
    Phone nightlyDiscountPolicyPhone() {
        return new Phone(
                new NightlyDiscountPolicy(
                        Money.wons(5),
                        Money.wons(10),
                        Duration.ofSeconds(10)));
    }

    // 일반 요금제 + 세금 정책
    Phone taxableRegularPolicyPhone() {
        return new Phone(
                new TaxablePolicy(  // 세금 정책
                        0.05,
                        new RegularPolicy(  // 일반 요금제
                                Money.wons(10),
                                Duration.ofSeconds(10))));
    }

    // ((일반 요금제 + 기본 요금 할인 정책) + 세금 정책)
    Phone regularRateDiscountTaxablePhone() {
        return new Phone(
                new TaxablePolicy(  // 세금 정책
                        0.05,
                        new RateDiscountablePolicy( // 기본 요금 할인 정책
                                Money.wons(1000),
                                new RegularPolicy(  // 일반 요금제
                                        Money.wons(10),
                                        Duration.ofSeconds(10)))));
    }

    // ((일반 요금제 + 세금 정책) + 기본 요금 할인 정책)
    Phone regularRateDiscountTaxablePhone1() {
        return new Phone(
                new RateDiscountablePolicy( // 기본 요금 할인 정책
                        Money.wons(1000),
                        new TaxablePolicy(  // 세금 정책
                                0.05,
                                new RegularPolicy(  // 일반 요금제
                                        Money.wons(10),
                                        Duration.ofSeconds(10)))));
    }

    // ((심야 할인 요금제 + 세금 정책) + 기본 요금 할인 정책)
    Phone rateDiscountNightlyPhone() {
        return new Phone(
                new RateDiscountablePolicy(
                        Money.wons(1000),
                        new TaxablePolicy(
                                0.05,
                                new NightlyDiscountPolicy(
                                        Money.wons(5),
                                        Money.wons(10),
                                        Duration.ofSeconds(10)))));
    }
}
