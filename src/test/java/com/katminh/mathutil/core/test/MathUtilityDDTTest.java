package com.katminh.mathutil.core.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.katminh.mathutil.core.MathUtility.getFactorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathUtilityDDTTest {
    // @Test là 1 phần annotation của framework, biến hàm của ta thành main để có thể run
    
    //Kĩ thuật DDT - DATA DRIVEN TESTING: kĩ thuật tách bộ data kiểm thử ra khỏi các câu lệnh kiểm thử, mục đích giúp
    //dev nhìn nhanh đc xem bộ testcase còn thiếu case nào không.
    //tên khác là tham số hóa bộ data kiểm thử: PARAMETERIZED TESTING


    //ta làm 1 hàm, phải là static, để lưu bộ data kiểm thử
    public static Object[][] initTestData(){
        return new Object[][]{
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
                {6, 7200},

        };
    }

    @ParameterizedTest
    @MethodSource("initTestData")
    void testFactorialGivenRightArgumentsRunsWell(int n, long expected) {
        assertEquals(expected, getFactorial(n));
    }

    public static Integer[] InitTestDataForCheckingException() {
        return new Integer[]{
                -1, -2, -3, -4, -5, -100, 21, 25, 100
        };
    }

    @ParameterizedTest
    @MethodSource("InitTestDataForCheckingException")
    void testFactorialGivenWrongArgumentsThrowsException(int n) {
        assertThrows(IllegalArgumentException.class, () -> getFactorial(n));
    }
}