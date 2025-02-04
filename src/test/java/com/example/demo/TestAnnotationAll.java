package com.example.demo;

import org.junit.jupiter.api.*;

class TestAnnotationAll
{

    @BeforeAll
    static void setupAll() {
        System.out.println("Before All: 테스트 전체 초기화 작업");
    }

    @BeforeEach
    void setup() {
        System.out.println("Before Each: 각 테스트 초기화 작업");
    }

    @Test
    void testAddition() {
        System.out.println("Test 1: Addition 테스트");
        Assertions.assertEquals(4, 2 + 3, "2 + 3은 5여야 합니다.");
    }

    @Test
    @Disabled("이 테스트는 현재 비활성화됨")
    void testDisabled() {
        System.out.println("Disabled Test: 실행되지 않음");
    }

    @Test
    void testSubtraction() {
        System.out.println("Test 2: Subtraction 테스트");
        Assertions.assertEquals(1, 3 - 2, "3 - 2는 1이어야 합니다.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Each: 각 테스트 정리 작업");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After All: 테스트 전체 정리 작업");
    }
}
