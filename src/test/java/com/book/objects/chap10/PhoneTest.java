package com.book.objects.chap10;

import com.book.objects.chap5.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneTest {

    @Test
    void 통화요금_계산(){
        RegularPhone regularPhone = new RegularPhone(Money.wons(5), Duration.ofSeconds(10));
        regularPhone.call(new Call(LocalDateTime.of(2018, 1, 1, 12, 10, 0),
                LocalDateTime.of(2018, 1, 1, 12, 11, 0)));
        regularPhone.call(new Call(LocalDateTime.of(2018, 1, 2, 12, 10, 0),
                LocalDateTime.of(2018, 1, 2, 12, 11, 0)));
        Money money = regularPhone.calculateFee();
        assertThat(money.getAmount()).isEqualTo(BigDecimal.valueOf(60.0));
    }

}