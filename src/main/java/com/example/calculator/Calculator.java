package com.example.calculator;

/**
 * Модуль Calculator для демонстрации автоматической генерации тестов.
 * 
 * Функциональные требования:
 * 1. add(int a, int b) — возвращает сумму
 * 2. subtract(int a, int b) — возвращает разность
 * 3. divide(int a, int b) — возвращает частное, при b=0 — исключение
 * 
 * Нефункциональные требования:
 * NFR-1: Результат в диапазоне int
 * NFR-2: Деление на ноль запрещено
 * NFR-3: Работа с целыми числами
 */
public class Calculator {
    
    /**
     * Сложение двух чисел.
     * Предусловие: a, b — целые числа
     * Постусловие: возвращает a + b
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Вычитание.
     * Предусловие: a, b — целые числа
     * Постусловие: возвращает a - b
     */
    public int subtract(int a, int b) {
        return a - b;
    }
    
    /**
     * Деление.
     * Предусловие: b != 0
     * Постусловие: возвращает a / b
     * Исключение: при b=0 выбрасывает IllegalArgumentException
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return (double) a / b;
    }
}