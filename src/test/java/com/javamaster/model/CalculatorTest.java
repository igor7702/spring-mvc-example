package com.javamaster.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ParameterResolver;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import com.javamaster.model.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTest {

    @DisplayName("JUnit5 - Calculator * ")
    @Test
    void multiplyTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6");
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "2,    3,   6",
            "5,    9,   45",
            "40,  50, 2000",
            "1,  100, 100"
    })
    void multiply(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.multiply(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @DisplayName("JUnit5 - Calculator + ")
    @Test
    void addsTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Disabled("Temporary disabled")
    @DisplayName("JUnit5 - Calculator /")
    @Test
    void divideTwoNumbers(){
        Calculator calculator = new Calculator();
        assertEquals(7, calculator.divide(28, 4), "28 / 4 should equal 7");
    }
}
