package dataProviders;

import org.testng.annotations.DataProvider;

public class CountryCityProvider {

    @DataProvider(name = "valid-Country-City")
    public static Object[][] validCountryCity() {
        return new Object[][]{
                {"Ukraine", "Dnipro"},
                {"Belarus", "Brest"},
                {"Ukraine", "Kyiv"},
                {"Belarus", "Gomel"},
                {"Belarus", "Gomel"},
                {"Belarus", "Gomel"},
                {"Belarus", "Gomel"},
                {"Belarus", "Gomel"},
                {"Ukraine", "Lutsk"},
                {"Belarus", "Grodno"},
                {"Ukraine", "Lviv"},
                {"Belarus", "Minsk"},
                {"Belarus", "Mogilev"},
                {"Belarus", "Polotsk"},
                {"Belarus", "Vitebsk"},
                {"Poland", "Krakow"},
                {"Ukraine", "Rivne"},
                {"Ukraine", "Ternopil"},
                {"Kazakhstan", "Almaty"},
                {"Kazakhstan", "Karaganda"}
        };
    }
}
