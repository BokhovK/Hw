package pro.sky.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.exception.DivideByZeroException;

public class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @Test
    void sumTest() {
        int a = 1;
        int b = 1;
        int expected = 2;
        int actual = calculatorService.sum(a,b);
        Assertions.assertEquals(expected, actual);


        a = -1;
        b = -1;
        expected = -2;
        actual = calculatorService.sum(a,b);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void multiplyTest() {
        int a = 1;
        int b = 1;
        int expected = 1;
        int actual = calculatorService.multiply(a,b);
        Assertions.assertEquals(expected, actual);


        a = -1;
        b = -1;
        expected = 1;
        actual = calculatorService.multiply(a,b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtractTest() {
        int a = 1;
        int b = 1;
        int expected = 0;
        int actual = calculatorService.subtract(a,b);
        Assertions.assertEquals(expected, actual);


        a = -1;
        b = -1;
        expected = 0;
        actual = calculatorService.subtract(a,b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divideTest() {
        int a = 1;
        int b = 1;
        int expected = 1;
        int actual = calculatorService.divide(a,b);
        Assertions.assertEquals(expected, actual);


        a = -1;
        b = -1;
        expected = 1;
        actual = calculatorService.divide(a,b);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void divideNegativeTest() {

        Assertions.assertThrows(DivideByZeroException.class, ()->calculatorService.divide(1,0));
    }
}
