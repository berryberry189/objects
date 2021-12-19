package com.book.objects.chap10;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {

    // 통화 시작 시간
    private LocalDateTime from;
    // 통화 종료 시간
    private LocalDateTime to;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    // from 과 to 사이의 간격
    public Duration getDuration(){
        return Duration.between(from, to);
    }

    public LocalDateTime getFrom() {
        return from;
    }
}
