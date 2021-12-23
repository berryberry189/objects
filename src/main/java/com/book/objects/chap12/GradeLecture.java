package com.book.objects.chap12;

import java.util.List;
import java.util.stream.Collectors;

/* 등급별 통계 */
public class GradeLecture extends Lecture{

    private List<Grade> grades;

    public GradeLecture(String title, int pass, List<Grade> grades, List<Integer> scores) {
        super(title, pass, scores);
        this.grades = grades;
    }

    /**
     * 자식 클래스와 부모 클래스에 완전히 동일한 시그니처를 가진 메서드가 존재할 경우
     * 자식 클래스의 메서드 우선순위가 더 높다
     * => 오버라이딩
     */
    @Override
    public String evaluate(){
        return super.evaluate() + ", " + gradeStatistics();
    }

    private String gradeStatistics() {
        return grades.stream()
                .map(grade -> format(grade))
                .collect(Collectors.joining(" "));
    }

    private String format(Grade grade) {
        return String.format("%s:%d", grade.getName(), gradeCount(grade));
    }

    private long gradeCount(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .count();
    }

    /**
     * 등급별 평균 구하기
     * (부모 클래스 Lecture 의 average 메서드와는 시그니처가 달라서 공존 가능 => 메서드 오버로딩 )
     * @param gradeName
     * @return
     */
    public double average(String gradeName){
        return grades.stream()
                .filter(each -> each.isName(gradeName))
                .findFirst()
                .map(this::gradeAverage)
                .orElse(0d);
    }

    private double gradeAverage(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }
}
