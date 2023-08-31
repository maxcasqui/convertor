package pe.com.convertor;

import java.util.ArrayList;

public class ConvertorTemperature {

    private final ArrayList<String> supportedUnits = new ArrayList<>();

    public ConvertorTemperature() {
        initializeSupportedUnits();
    }

    private void initializeSupportedUnits() {
        supportedUnits.add("Celsius");
        supportedUnits.add("Fahrenheit");
        supportedUnits.add("Kelvin");
    }

    public double convert(double value, String fromUnit, String toUnit) {

        switch (fromUnit) {
            case "Celsius":
                if (toUnit.equals("Fahrenheit")) {
                    return (value * 9.0 / 5.0) + 32;
                } else if (toUnit.equals("Kelvin")) {
                    return value + 273.15;
                }
                break;
            case "Fahrenheit":
                if (toUnit.equals("Celsius")) {
                    return (value - 32) * 5.0 / 9.0;
                } else if (toUnit.equals("Kelvin")) {
                    return (value - 32) * 5.0 / 9.0 + 273.15;
                }
                break;
            case "Kelvin":
                if (toUnit.equals("Celsius")) {
                    return value - 273.15;
                } else if (toUnit.equals("Fahrenheit")) {
                    return (value - 273.15) * 9.0 / 5.0 + 32;
                }
                break;
        }

        return value;
    }
}
