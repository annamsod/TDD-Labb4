import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorCLITests {

    @Test
    public void testWelcomeText(){
        String input = "exit";
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

        String expectedOut = "Enter your input: " + System.lineSeparator() +
                "The result is 0" + System.lineSeparator() +
                "Enter your input: " + System.lineSeparator() +
                "Exiting..." +System.lineSeparator();
        String actualOut = outputStream.toString().substring(outputStream.toString().indexOf("Enter"));

        assertEquals(expectedOut,actualOut);
    }

    @Test
    public void testEmptyNumberString2() {
        String input = "scalc ''\nexit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        String expectedOut = "Enter your input: " + System.lineSeparator() +
                "The result is 0" + System.lineSeparator() +
                "Enter your input: " + System.lineSeparator() +
                "Exiting..." +System.lineSeparator();
        String actualOut = outputStream.toString().substring(outputStream.toString().indexOf("Enter"));

        assertEquals(expectedOut,actualOut);

    }

    @Test
    public void testNumberString1() {
        String input = "scalc '1,2,3'\nexit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        String expectedOut ="Enter your input: " + System.lineSeparator() +
                "The result is 6" + System.lineSeparator() +
                "Enter your input: " + System.lineSeparator() +
                "Exiting..." +System.lineSeparator();
        String actualOut = outputStream.toString().substring(outputStream.toString().indexOf("Enter"));

        assertEquals(expectedOut,actualOut);
    }

    @Test
    public void testNumberString2() {
        String input = "scalc '1,2,3,4,5,6'\nexit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        String expectedOut = "Enter your input: " + System.lineSeparator() +
                "The result is 21" + System.lineSeparator() +
                "Enter your input: " + System.lineSeparator() +
                "Exiting..." +System.lineSeparator();
        String actualOut = outputStream.toString().substring(outputStream.toString().indexOf("Enter"));

        assertEquals(expectedOut,actualOut);
    }

    @Test
    public void testMultipleNumberStrings1() {
        String input = "scalc '1,2,3'\nscalc '2,3,4'\nexit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        String expectedOut = "Enter your input: " + System.lineSeparator() +
                "The result is 6" + System.lineSeparator() +
                "Enter your input: " + System.lineSeparator() +
                "The result is 9" + System.lineSeparator() +
                "Enter your input: " + System.lineSeparator() +
                "Exiting..." +System.lineSeparator();
        String actualOut = outputStream.toString().substring(outputStream.toString().indexOf("Enter"));

        assertEquals(expectedOut,actualOut);
    }

    @Test
    public void testMultipleNumberStringsEnterToExit() {
        String input = "scalc '1,2,3'\nscalc '2,3,4'\n\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        String expectedOut = "Enter your input: " + System.lineSeparator() +
                "The result is 6" + System.lineSeparator() +
                "Enter your input: " + System.lineSeparator() +
                "The result is 9" + System.lineSeparator() +
                "Enter your input: " + System.lineSeparator() +
                "Exiting..." +System.lineSeparator();
        String actualOut = outputStream.toString().substring(outputStream.toString().indexOf("Enter"));

        assertEquals(expectedOut,actualOut);
    }

    @Test
    public void testExitWithEnter() {

        String input = "\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        String expectedOut = "Enter your input: " + System.lineSeparator() +
                "Exiting..." +System.lineSeparator();
        String actualOut = outputStream.toString().substring(outputStream.toString().indexOf("Enter"));

        assertEquals(expectedOut,actualOut);
    }

    @Test
    public void testComplexNumberStrings1() {
        String input = "scalc '//;\\n1;2;4'\nexit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        String expectedOut = "Enter your input: " + System.lineSeparator() +
                "The result is 7" + System.lineSeparator() +
                "Enter your input: " + System.lineSeparator() +
                "Exiting..." +System.lineSeparator();
        String actualOut = outputStream.toString().substring(outputStream.toString().indexOf("Enter"));

        assertEquals(expectedOut,actualOut);
    }

    @Test
    public void testComplexNumberStrings2() {
        String input = "scalc '//[***][%%%]\\n1***2%%%4'\nexit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        String expectedOut = "Enter your input: " + System.lineSeparator() +
                "The result is 7" + System.lineSeparator() +
                "Enter your input: " + System.lineSeparator() +
                "Exiting..." +System.lineSeparator();
        String actualOut = outputStream.toString().substring(outputStream.toString().indexOf("Enter"));

        assertEquals(expectedOut,actualOut);
    }

    @Test
    public void testComplexNumberStrings3() {
        String input = "scalc '//[*][%%][xyz]\\n1*2%%4xyz5'\nexit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        String expectedOut = "Enter your input: " + System.lineSeparator() +
                "The result is 12" + System.lineSeparator() +
                "Enter your input: " + System.lineSeparator() +
                "Exiting..." +System.lineSeparator();
        String actualOut = outputStream.toString().substring(outputStream.toString().indexOf("Enter"));

        assertEquals(expectedOut,actualOut);
    }
}