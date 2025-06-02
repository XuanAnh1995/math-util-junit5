/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.luuviet.mathutil.core;

import static com.luuviet.mathutil.core.MathUtil.*;
// import static là dành riêng cho những hàm static
// gọi hàm mà bỏ qua tên class

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author luuvi
 */
public class MathUtilTest {

    // chơi DDT , tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này vào trong câu lệnh kiểm thử
    // chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][]{
            {0, 1},
            {1, 1},
            {2, 2},
            {3, 6},
            {4, 24},
            {5, 120},
        };
    }

    @ParameterizedTest
    @MethodSource(value = "initData")   // tên hàm cung cấp data , ngầm định thứ tự của mảng
    public void testGetFactorialGivenRightArgReturnWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }

//    @Test
//    public void testGetFactorialGivenRightArgReturnWell(){
//        assertEquals(24, getFactorial(4));
//    }
    
    
    // Bắt ngoại lệ khi data cà chớn
    // @Test(expected = tên ngoại lệ.class) JUnit hoy, JUnit kok xài vậy
    @Test
    public void testGetFactorialGivenWrongArgThrowException() {

        // Biểu thức Lambda
        // Hàm nhận tham số thứ 2 là 1 object có code implement cái
        // function interface tên là Executable - có 1 hàm duy nhất ko code
        // tên là execute()
        // chơi chậm
        
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };
        assertThrows(IllegalArgumentException.class, () -> {
            getFactorial(-10);
        });
    }

}
