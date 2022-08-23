package lesson6;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class FunctionForTestingTest {

    @BeforeEach
    void startUp() {
        System.out.println("начинается тест");
    }

    @AfterEach
    void afterEach() {
        System.out.println("завершается тест");
    }

    @AfterAll
    static void mainEnd() {
        System.out.println("ГЛАВНОЕ ОКОНЧАНИЕ");
    }

    @BeforeAll
    static void mainStart() {
        System.out.println("ГЛАВНОЕ НАЧАЛО");
    }

    @DisplayName("Параметризированный тест копирования массива после последней 4-ки")
    @ParameterizedTest
    @MethodSource("dataForLastFour")
    void paramTestForLastFour(int[] expected, int[] a) {
        Assertions.assertArrayEquals(expected, FunctionForTesting.method1(a));
    }

    static Stream<Arguments> dataForLastFour() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 3}, new int[]{1, 4, 5, 6, 7, 4, 2, 3}),
                Arguments.arguments(new int[]{5, 6, 7, 8, 2, 3}, new int[]{1, 4, 5, 6, 7, 8, 2, 3}),
                Arguments.arguments(new int[]{3}, new int[]{1, 9, 5, 6, 7, 4, 4, 3})

        );
    }

    @DisplayName("Проверка исключения  для массива {1, 9, 5, 6, 7, 0, 2, 3}")
    @Test
    void testExceptionForLastFour() {
        Assertions.assertThrows(RuntimeException.class, () -> FunctionForTesting.method1(new int[]{1, 9, 5, 6, 7, 0, 2, 3}));
    }

    @DisplayName("Параметризированный тест успешной проверки  наличия 1 или 4 в массиве")
    @ParameterizedTest
    @MethodSource("dataForHaveOneOrFourTrue")
    void dataForHaveOneOrFourTrue(int[] a) {
        Assertions.assertTrue(FunctionForTesting.method2(a));
    }

    @DisplayName("Параметризированный тест НЕуспешной проверки  наличия 1 или 4 в массиве")
    @ParameterizedTest
    @MethodSource("dataForHaveOneOrFourFalse")
    void dataForHaveOneOrFourFalse(int[] a) {
        Assertions.assertFalse(FunctionForTesting.method2(a));
    }

    static Stream<Arguments> dataForHaveOneOrFourTrue() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 4, 5, 6, 7, 4, 2, 3}),
                Arguments.arguments(new int[]{0, 4, 4, 4, 1, 1, 2, 3}),
                Arguments.arguments(new int[]{1, 4})

        );
    }

    static Stream<Arguments> dataForHaveOneOrFourFalse() {
        return Stream.of(
                Arguments.arguments(new int[]{}),
                Arguments.arguments(new int[]{0, 4, 5, 6, 7, 8, 2, 3}),
                Arguments.arguments(new int[]{1, 9, 5, 6, 7, 2, 8, 3})

        );
    }

}