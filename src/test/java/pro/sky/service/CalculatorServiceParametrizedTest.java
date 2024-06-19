package pro.sky.service;

import net.bytebuddy.asm.MemberSubstitution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.exception.DivideByZeroException;

import java.util.stream.Stream;

public class CalculatorServiceParametrizedTest {
    private final CalculatorService calculatorService = new CalculatorService();
    @ParameterizedTest
    @MethodSource("provideParamsForSum")
    void sumTest(int a, int b, int expected){
        int actual = calculatorService.sum(a, b);
        Assertions.assertEquals(expected, actual);

    }
    static Stream<Arguments> provideParamsForSum(){
       return Stream.of(
               Arguments.of(1,1,2),
               Arguments.of(1,2,3)
       );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForSubtract")
    void subtractTest(int a, int b, int expected){
        int actual = calculatorService.subtract(a, b);
        Assertions.assertEquals(expected, actual);

    }
    static Stream<Arguments> provideParamsForSubtract(){
        return Stream.of(
                Arguments.of(1,1,0),
                Arguments.of(5,5,0)
        );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForDivide")
    void divideTest(int a, int b, int expected){
        int actual = calculatorService.divide(a, b);
        Assertions.assertEquals(expected, actual);

    }
    static Stream<Arguments> provideParamsForDivide(){
        return Stream.of(
                Arguments.of(1,1,1),
                Arguments.of(2,1,2)
        );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForMultiply")
    void multiplyTest(int a, int b, int expected){
        int actual = calculatorService.multiply(a, b);
        Assertions.assertEquals(expected, actual);

    }
    static Stream<Arguments> provideParamsForMultiply(){
        return Stream.of(
                Arguments.of(1,2,2),
                Arguments.of(1,0,0)
        );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForDivideNegative")
    void divideNegativeTest(int a, int b, int expected){
        Assertions.assertThrows(DivideByZeroException.class, ()->calculatorService.divide(a,b));

    }
    static Stream<Arguments> provideParamsForDivideNegative(){
        return Stream.of(
                Arguments.of(1,0),
                Arguments.of(-1,0)
        );
    }
}
