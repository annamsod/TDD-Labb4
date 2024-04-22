import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StringCalculatorCLI {

    private final InputStream inputStream;
    private final OutputStream outputStream;

    public StringCalculatorCLI(){
        inputStream = System.in;
        outputStream = System.out;
    }

    public StringCalculatorCLI(InputStream inputStream, OutputStream outputStream){
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }


    public void run() {
        Scanner scanner = new Scanner(inputStream);
        PrintStream out = new PrintStream(outputStream);

        out.println("""
                Welcome!
                To use the program enter a string looking like this: "scalc ‘1,2,3’"
                The program will return the sum of the numbers.
                To exit type "exit"\s
                """);

        StringCalculator calculator = new StringCalculator();

        // Loop until the user inputs "exit"
        while (true) {
            out.println("Enter your input: ");
            String input = scanner.nextLine(); // Read the next line of input

            // Check if the user wants to exit
            if ("exit".equalsIgnoreCase(input) || input.isEmpty()) {
                break; // Exit the loop
            }

            // Process the input
            //TODO Handle "scalc"-formatted string
            else if (input.startsWith("scalc ")) {
                if(input.startsWith("//")){
                    input=input.replaceAll("\\n", "\n");
                }
                input=input.substring(input.indexOf("'")+1, input.lastIndexOf("'"));

            }
            var result = calculator.add(input);

            out.println("The result is "+ result);
        }

        scanner.close();
        out.println("Exiting...");

    }
}
