#!/usr/bin/env python3
import yaml
import argparse
from pathlib import Path

TEMPLATE = '''package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
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
    @CsvSource(
        "2, 3, 5",
        "-2, -3, -5",
        "0, 5, 5",
        "1000000, 2000000, 3000000"
    )
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }
    
    @ParameterizedTest
    @CsvSource(
        "5, 3, 2",
        "3, 5, -2"
    )
    void testSubtract(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }
    
    @ParameterizedTest
    @CsvSource(
        "10, 2, 5.0",
        "7, 2, 3.5",
        "5, 0, -1.0"
    )
    void testDivide(int a, int b, double expected) {
        if (b == 0) {
            assertThrows(IllegalArgumentException.class, () -> {
                calculator.divide(a, b);
            });
        } else {
            assertEquals(expected, calculator.divide(a, b), 0.001);
        }
    }
}
'''

def generate(config_path):
    with open(config_path, "r", encoding="utf-8") as f:
        config = yaml.safe_load(f)
    
    out_dir = Path(config.get("output_dir", "src/test/java/com/example/calculator"))
    out_dir.mkdir(parents=True, exist_ok=True)
    output_file = out_dir / "CalculatorGeneratedTest.java"
    output_file.write_text(TEMPLATE, encoding="utf-8")
    
    print(f"[OK] Generated: {output_file}")

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("--config", default="config.yaml")
    args = parser.parse_args()
    generate(args.config)
    print("[OK] Done!")