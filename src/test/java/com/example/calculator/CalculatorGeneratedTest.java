package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorGeneratedTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @AfterEach
    void tearDown() {
        calculator = null;
    }
    
    @ParameterizedTest
    @CsvSource(value = {
        "2, 3, 5",
        "-2, -3, -5",
        "0, 5, 5",
        "1000000, 2000000, 3000000"
    })
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }
    
    @ParameterizedTest
    @CsvSource(value = {
        "5, 3, 2",
        "3, 5, -2"
    })
    void testSubtract(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }
    
    @ParameterizedTest
    @CsvSource(value = {
        "10, 2, 5.0",
        "7, 2, 3.5"
    })
    void testDivideNormal(int a, int b, double expected) {
        assertEquals(expected, calculator.divide(a, b), 0.001);
    }
    
    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });
    }
}