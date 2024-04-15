import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class StringCalculatorLoggingTests {

    private StringCalculator calculator;
    private Logger mockLogger;

    @BeforeEach
    public void beforeEach() {
        mockLogger = mock(Logger.class);
        calculator = new StringCalculator(mockLogger);
    }
    @Test
    public void testStringCalculatorDoesNotLogNumbersBelow1000(){
        calculator.add("");
        verify(mockLogger, times(0)).log(anyInt());
    }

    @Test
    public void testStringCalculatorDoesNotLogNumbersBelow1000V2(){
        calculator.add("999");
        verify(mockLogger, times(0)).log(anyInt());
    }

    @Test
    public void testStringCalculatorLog1000(){
        calculator.add("1000");
        verify(mockLogger, times(1)).log(anyInt());
    }

    @Test
    public void testStringCalculatorLog1000As1000(){
        calculator.add("1000");
        verify(mockLogger).log(1000);
    }

    @Test
    public void testStringCalculatorLog2Numbers(){
        calculator.add("1000,2000,35");
        verify(mockLogger, times(2)).log(anyInt());
    }

    @Test
    public void testStringCalculatorLogEachNumberOnce(){
        calculator.add("1000,1000,35");
        verify(mockLogger, times(1)).log(anyInt());
    }
}
