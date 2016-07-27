package main.java;



public class Calculation {
    private ExchangeRateProvider exchangeRateProvider;
    public double result;

     public Calculation(ExchangeRateProvider exchangeRateProvider)
     {
         this.exchangeRateProvider = exchangeRateProvider;
     }

     public double Calculate(String currentCurrency,String desiredCurrency,double amount, Double rateIncreaser)
     {

         return Multiply(amount,exchangeRateProvider.FindRate(currentCurrency,desiredCurrency,rateIncreaser));
     }

     public double Multiply(double amount,double rate)
     {
         result = rate*amount;
         return result;
     }


}
