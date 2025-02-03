package com.example.demo.naver;

public class APIExamTranslateUse {
    public static void main(String[] args) {
        APIExamTranslate3KO naver = new APIExamTranslate3KO();
        String result = naver.trans("수요일 오후!! 제일 졸리는 날!!! 다음주에 실컷 놀자!");
        System.out.println("==============================");
        System.out.println("번역한 결과 >> " + result);
    }
}
