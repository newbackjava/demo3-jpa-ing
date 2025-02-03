package com.example.demo.naver;

public class APIExamTranslateUse2 {
    public static void main(String[] args) {
        APIExamTranslate3EN naver = new APIExamTranslate3EN();
        String result = naver.trans("Turn your wounds into wisdom");
        System.out.println("==============================");
        System.out.println("번역한 결과 >> " + result);
    }
}
