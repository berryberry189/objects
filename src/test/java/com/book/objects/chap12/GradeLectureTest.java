package com.book.objects.chap12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GradeLectureTest {

    Lecture getLecture = new GradeLecture("객체지향 프로그래밍",
            70,
            Arrays.asList(new Grade("A", 100, 95),
                    new Grade("B", 94, 80),
                    new Grade("C", 79, 70),
                    new Grade("D", 69, 50),
                    new Grade("F", 49, 0)),
            Arrays.asList(81, 95, 75, 50, 45));

    @Test
    @DisplayName("이수한 학생의 수와 낙제한 학생의 수, 각 등급을 표현하는 문자열을 리턴한다")
    void 성적등급_구하기(){
        String result = getLecture.evaluate();
        Assertions.assertEquals(result, "Pass:3 Fail:2, A:1 B:1 C:1 D:1 F:1");
    }

}
