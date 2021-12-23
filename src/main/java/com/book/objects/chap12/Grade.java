package com.book.objects.chap12;

/* 등급 */
public class Grade {

    // 등급명
    private String name;
    // 최소 성적, 최대 성적
    private int upper, lower;

    public Grade(String name, int upper, int lower){
        this.name = name;
        this.upper = upper;
        this.lower = lower;
    }

    public String getName() {
        return name;
    }

    public boolean isName(String name){
        return this.name.equals(name);
    }

    public boolean include(int score){
        return score >= lower && score <= upper;
    }

}
