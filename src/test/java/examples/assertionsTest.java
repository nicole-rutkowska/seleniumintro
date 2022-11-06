package examples;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class assertionsTest {
    public static final int x = 1;
    public static final int y = 2;

    Calculator calculator = new Calculator();

    private int correctExpectedResult = 3;
    private int incorrectExpectedResult = 4;
    private int actualResult = calculator.add(x, y);

    @Test
    public void assertTrueTest() {
        assertTrue(correctExpectedResult == actualResult);
    }

    @Test
    public void asserFalseTest() {
        assertFalse(incorrectExpectedResult == actualResult);
    }

    @Test
    public void assertEqualsTest() {
        assertEquals(correctExpectedResult, actualResult);
    }
}
