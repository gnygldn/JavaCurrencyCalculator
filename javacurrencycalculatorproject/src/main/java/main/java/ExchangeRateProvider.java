package main.java;




public class ExchangeRateProvider {
    public ExchangeInfoList ConvertedList;
    public ExchangeRateProvider(ExchangeInfoList exchangeInfoList)
    {
        ConvertedList = exchangeInfoList;
    }
    public double FindRate(String currentCurrency, String desiredCurrency, double rateIncreaser)
    {
        for (CurrencyPair pair:
             ConvertedList.currencyPairs) {
            if (pair.baseCurrency.equals(currentCurrency) && pair.counterCurrency.equals(desiredCurrency)) {
                return (100 + rateIncreaser) / 100 * (pair.rate);
            }
        }
        return 0;
    }

}
