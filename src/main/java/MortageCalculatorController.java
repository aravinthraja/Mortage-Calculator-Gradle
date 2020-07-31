import task.MortgageProcessorTask;
import task.MortgageProcessorTaskImpl;
import task.ValidateInputTask;
import task.ValidateInputTaskImpl;

import java.util.HashMap;
import java.util.Map;

public class MortageCalculatorController {
    final private static MortgageProcessorTask mortgageProcessorTask = new MortgageProcessorTaskImpl();
    final private static ValidateInputTask validateInputTask = new ValidateInputTaskImpl();


    public static Map<String,String> getRequest(){
        Map<String,String> map = new HashMap<>();
        map.put("Principal","1000.00");
        map.put("Term","12");
        map.put("Type","Interest");
       // map.put("Type","Fixed");
        return map;
    }

    public static void main(String[] args) {
        Map<String,String> request = getRequest();

        validateInputTask.validate(request);
        String result = mortgageProcessorTask.process(request);

        System.out.println(result);


    }
}
