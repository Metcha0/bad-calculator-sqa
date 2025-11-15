package edu.pnu.badcalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    // Test add method
    @Test
    public void testAdd() {
        assertEquals(5.0, calc.add(2, 3));
        assertEquals(-1.0, calc.add(-2, 1));
        assertEquals(0.0, calc.add(0, 0));
    }

    // Test subtract method
    @Test
    public void testSubtract() {
        assertEquals(1.0, calc.subtract(3, 2));
        assertEquals(-3.0, calc.subtract(-2, 1));
        assertEquals(0.0, calc.subtract(0, 0));
    }

    // Test multiply method
    @Test
    public void testMultiply() {
        assertEquals(6.0, calc.multiply(2, 3));
        assertEquals(-2.0, calc.multiply(-2, 1));
        assertEquals(0.0, calc.multiply(0, 10));
    }

    // Test divide method
    @Test
    public void testDivide() {
        assertEquals(2.0, calc.divide(6, 3));
        assertEquals(-2.0, calc.divide(-4, 2));

        Exception exception = assertThrows(ArithmeticException.class, () -> calc.divide(1, 0));
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    // Test factorial method
    @Test
    public void testFactorial() {
        assertEquals(120, calc.factorial(5));
        assertEquals(1, calc.factorial(0));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.factorial(-3));
        assertEquals("Negative factorial not defined", exception.getMessage());
    }

    // Test parseAndCompute method
    @Test
    public void testParseAndCompute() {
        assertEquals(5.0, calc.parseAndCompute("2 + 3"));
        assertEquals(1.0, calc.parseAndCompute("3 - 2"));
        assertEquals(6.0, calc.parseAndCompute("2 * 3"));
        assertEquals(2.0, calc.parseAndCompute("6 / 3"));

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> calc.parseAndCompute("2 ^ 3"));
        assertTrue(ex1.getMessage().contains("Unknown operator"));

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> calc.parseAndCompute("2 +"));
        assertTrue(ex2.getMessage().contains("Expression must be in format"));
    }
}