package com.katminh.mathutil.core.test;

import static com.katminh.mathutil.core.MathUtility.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilityTest {

    //Test case #3: check getFactorial() with n = -5 to see Exception
    @Test
    void testFactorialGivenWrongArgumentThrowsException(){
//        getFactorial(-5);
        assertThrows(IllegalArgumentException.class, () -> {getFactorial(-5);});
    }

    @Test
    //Test case #2: check getFactorial() with n = 5 to see result of 1
    void testFactorialGivenRightArgument5RunsWell(){
        assertEquals(1, getFactorial(1));
        assertEquals(2, getFactorial(2));
        assertEquals(6, getFactorial(3));
        assertEquals(24, getFactorial(4));
        assertEquals(120, getFactorial(5));
        assertEquals(720, getFactorial(6));

    }
    //Cấu trúc test case: ID, Desc, Steps/Procedures, Expected Result,
    //                      Actual Result, Status: Passed, Failed,
    //                      Test Date, Bug # (bug id) Bugzilla (bug db)
    //                                                  Jira
    //Test case #1: check getFactorial() with n = 0 to see result of 1
    //
    @Test
    void testFactorialGivenRightArgument0RunsWell(){
      long expectedValue = 1; // hy vọng 0! trả về 1
      long actualValue = getFactorial(0);
      // so sánh
      // truyền thống ta sout() in kết quả và nhìn = mắt để đoán đúng sai
      // hiện đại: xài thêm tool, thư viện, unit testing framework JUnit
      // Giúp đôi mắt ta nhinf kết quả đúng sai qua 2 màu xanh và đỏ
      assertEquals(expectedValue, actualValue);
    }
}

//QUY TẮC XANH ĐỎ CỦA UNIT TEST TOOL/FRAMEWORK
//NẾU TẤT CẢ CÁC TEST CASE PASSED (EXPECTED == ACTUAL) => MÀU XANH
//CHỈ CẦN 1 TRONG NHỮNG TEST CASE FAILED (EXPECTED != ACTUAL) => MÀU ĐỎ
//LÝ DO: HÀM ĐÃ ĐÚNG THÌ PHẢI ĐÚNG HẾT VỚI CÁC TEST CASE ĐÃ ĐƯA RA!!!
//MẮT CHỈ NHÌN 2 TÍN HIỆU - XANH, ĐỎ THEO STYLE GỘP CÁC KẾT QUẢ
//XANH: ĐÚNG HẾT, ĐỎ: 1 THẰNG NÀO CHẾT -> BỎ HÀM, FIX LẠI!!!

//KĨ THUẬT VIẾT CODE CHÍNH (HÀM TRONG API, CORE,...)
//MÀ ĐI KÈM CODE TEST HÀM LUÔN, DÙNG 2 TRẠNG THÁI XANH ĐỎ, CỨ LIÊN TỤC CODE
// XONG CHẠY XANH ĐỎ, SỬA, CHẠY LẠI XANH ĐỎ, TỐI ƯU CHỈNH CODE, CHẠY LẠI XANH
//ĐỎ, XANH ĐỎ LIÊN TỤC TRONG QUÁ TRÌNH VIẾT CODE ĐƯỢC GỌI LÀ TDD
// TEST DRIVEN DEVELOPMENT - VIẾT CODE SONG HÀNH CÙNG CODE TEST 