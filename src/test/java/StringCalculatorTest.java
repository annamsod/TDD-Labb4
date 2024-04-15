import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculator();
    }

    @Test
    public void testEmptyStringReturnsZero() {
        Assertions.assertEquals(0, calculator.add(""));
    }

    @Test
    public void testOneNumberReturnNumber(){
        Assertions.assertEquals(5, calculator.add("5"));
    }

    @Test
    public void testTwoNumbersReturnSum(){
        Assertions.assertEquals(8,calculator.add("5,3"));
    }

    @Test
    public void testWrongAnswer(){
        Assertions.assertNotEquals(10,calculator.add("5,3"));
    }

    @Test
    public void testThreeNumbers(){
        Assertions.assertEquals(6,calculator.add("1,2,3"));
    }

    @Test
    public void testTenNumbers(){
        Assertions.assertEquals(10,calculator.add("1,1,1,1,1,1,1,1,1,1"));
    }

    @Test
    public void testStringWithNewRow(){
        Assertions.assertEquals(10,calculator.add("2\n5,3"));
    }

    @Test
    public void testDifferentDivider(){
        Assertions.assertEquals(3,calculator.add("//;\n1;2"));
    }

    @Test
    public void testOnlyNegativeNumber(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculator.add("-8"));
        Assertions.assertEquals("Negatives not allowed: -8", exception.getMessage());
    }

    @Test
    public void testNegativeNumber(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculator.add("1,-2"));
        Assertions.assertEquals("Negatives not allowed: -2", exception.getMessage());
    }

}
