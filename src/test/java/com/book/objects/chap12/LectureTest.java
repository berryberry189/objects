package com.book.objects.chap12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LectureTest {

    Lecture getLecture = new Lecture("객체지향 프로그래밍",
            70,
            Arrays.asList(81, 90, 65, 70, 45));

    @Test
    @DisplayName("이수한 학생의 수와 낙제한 학생의 수를 표현하는 문자열을 리턴한다")
    void 성적통계_구하기(){
        String result = getLecture.evaluate();
        Assertions.assertEquals(result, "Pass:3 Fail:2");
    }

}
