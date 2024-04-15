import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private final Logger logger;

    public StringCalculator(){
        logger = new LoggerStub();
    }

    public StringCalculator(Logger logger){
        this.logger = logger;
    }

    public int add(String input) throws IllegalArgumentException {
        int sum=0;
        List<Object> loggedNumbers = new ArrayList<>();
        if(!input.isEmpty()) {
            String[] numbers;
            if(input.startsWith("//")){
                char divider = input.charAt(2);
                String newString = input.substring(input.indexOf("\n")+1);
                numbers = newString.split(String.valueOf(divider));
            }
            else {
                numbers = input.split("[, \n]");
            }
            for (String number : numbers) {
                int num = Integer.parseInt(number);
                if(num<0){
                    throw new IllegalArgumentException("Negatives not allowed: " + num);
                }
                else if(num>=1000&&!loggedNumbers.contains(num)){
                    logger.log(num);
                    loggedNumbers.add(num);
                }
                sum += num;
            }
        }
        return sum;
    }
}
