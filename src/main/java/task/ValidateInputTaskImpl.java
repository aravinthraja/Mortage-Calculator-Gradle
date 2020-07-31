package task;

import java.util.Map;

public class ValidateInputTaskImpl implements ValidateInputTask {

    @Override
    public void validate(Map<String, String> request) {

            if (request == null)
                System.out.println("Request Empty");

            if (request.get("Principal") == null)
                System.out.println("Principal Not found");

            if (request.get("Term") == null)
                System.out.println("Term  Not found");

    }
}
