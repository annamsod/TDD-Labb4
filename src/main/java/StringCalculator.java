import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                if(input.indexOf("n")==4) {
                    char divider = input.charAt(2);
                    String newString = input.substring(input.indexOf("n") + 1);
                    numbers = newString.split(String.valueOf(divider));
                }
                else{
                    String[] delimerters = (input.substring(3,input.lastIndexOf(']')).split("]\\["));
                    String num = input.substring(input.lastIndexOf(']') + 3);
                    for(String del : delimerters) {
                        num = num.replace(del, ",");
                    }
                    numbers = num.split("[, \n]");
                }
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
