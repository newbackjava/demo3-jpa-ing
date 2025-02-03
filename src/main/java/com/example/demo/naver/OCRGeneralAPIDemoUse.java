package com.example.demo.naver;

public class OCRGeneralAPIDemoUse {
    public static void main(String[] args) {
        OCRGeneralAPIDemo2 ocr = new OCRGeneralAPIDemo2();
        String result = ocr.ocr("doc1.jpg");
        System.out.println("추출한 result: " + result);
    }
}
