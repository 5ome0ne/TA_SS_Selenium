package dataProviders;

import consts.CountryCityValues;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class CountryCityProvider {

    @DataProvider(name = "valid-Country-City")
    public static Object[][] validCountryCity() {
        return Arrays.stream(CountryCityValues.values())
                .map(e -> new Object[]{e.getCountry(), e.getCity()})
                .toArray(Object[][]::new);
    }
}
