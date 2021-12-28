package com.book.objects.chap12;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    @Nested
    class professorLectureTest{

        Professor getProfessor() {
          return  new Professor("다익스트라",
                  new Lecture("알고리즘",
                          70,
                          Arrays.asList(81, 95, 75, 50, 45)));
        }

        @Test
        void 다익스트라_교수의_알고리즘_인자가_Lecture_일떄(){
            String result = getProfessor().compileStatistics();
            assertEquals(result, "[다익스트라] Pass:3 Fail:2 - Avg: 69.2");
        }

    }

    @Nested
    class professorGradeLectureTest{

        Professor getProfessor() {
            return new Professor("다익스트라",
                    new GradeLecture("알고리즘", 70,
                            Arrays.asList(
                                    new Grade("A", 100, 95),
                                    new Grade("B", 94, 80),
                                    new Grade("C", 79, 70),
                                    new Grade("D", 69, 50),
                                    new Grade("F", 49, 0)),
                            Arrays.asList(81, 95, 75, 50, 45)));
        }

        @Test
        void 다익스트라_교수의_알고리즘_인자가_GradeLecture_일떄(){
            String result = getProfessor().compileStatistics();
            assertEquals(result, "[다익스트라] Pass:3 Fail:2, A:1 B:1 C:1 D:1 F:1 - Avg: 69.2");
        }

    }
}