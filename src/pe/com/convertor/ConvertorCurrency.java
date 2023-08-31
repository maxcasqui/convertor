package pe.com.convertor;

import java.util.HashMap;
import java.util.Map;

public class ConvertorCurrency {
    private final Map<String, Double> exchangeRates;

    public ConvertorCurrency() {
        exchangeRates = new HashMap<>();
        initializeExchangeRates();
    }

    private void initializeExchangeRates() {
        exchangeRates.put("Soles", 1.0);
        exchangeRates.put("Dolares", 0.27);
        exchangeRates.put("Euros", 0.25);
        exchangeRates.put("Libras Esterlinas", 0.21);
        exchangeRates.put("Yen Japones", 39.67);
        exchangeRates.put("Won Sur Coreano", 357.79);
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double conversionRateFrom = exchangeRates.get(fromCurrency);
        double conversionRateTo = exchangeRates.get(toCurrency);

        return amount * (conversionRateTo / conversionRateFrom);
    }
}
