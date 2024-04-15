import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorCLITests {

    @Test
    public void testWelcomeText(){
        String input = "exit\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        String expectedOutput1 = "Welcome!\n";
        String expectedOutput2 = "To use the program enter a string looking like this: \"scalc ‘1,2,3’\"\n";
        String expectedOutput3 = "The program will return the sum of the numbers.";
        String expectedOutput4 = "To exit type \"exit\"";

        assertTrue(outputStream.toString().contains(expectedOutput1));
        assertTrue(outputStream.toString().contains(expectedOutput2));
        assertTrue(outputStream.toString().contains(expectedOutput3));
        assertTrue(outputStream.toString().contains(expectedOutput4));
    }

    @Test
    public void testEmptyNumberString() {

        String input = "scalc ''\nexit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        assertEquals("0\nExiting...\n", outputStream.toString());
    }

    @Test
    public void testEmptyNumberString2() {
        String input = "scalc ''\nexit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        assertEquals("0\nExiting...\n", outputStream.toString());

    }


}