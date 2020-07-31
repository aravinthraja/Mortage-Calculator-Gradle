package task;

import service.InterestRateService;
import service.InterestRateServiceImpl;

import java.util.Map;

public class MortgageProcessorTaskImpl  implements  MortgageProcessorTask{

    private MortgageCalculatorTask getByType(String type){
        if(type.equals("Fixed")){
            return new FixedRateMortgageCalculatorTaskImpl();
        } else {
            return new InterestOnlyMortgageCalculatorTaskImpl();
        }
    }

    @Override
    public String process(Map<String, String> request) {
        if(request.get("Interest") == null){
            InterestRateService interestRateService = new InterestRateServiceImpl();
            MortgageCalculatorTask mortgageCalculatorTask = getByType(request.get("Type"));



            double principal =  Double.parseDouble( request.get("Principal") );
            double yearlyInterest = interestRateService.getRates();
            int term = Integer.parseInt( request.get("Term") );
            double value = mortgageCalculatorTask.calculateMonthlyPayment(principal,yearlyInterest,term);

            return String.valueOf(value);
        } else {
            return "Not Valid";
        }
    }
}
