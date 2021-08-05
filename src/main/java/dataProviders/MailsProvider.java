package dataProviders;

import consts.values.InvalidMailsValues;
import consts.values.ValidMailsValues;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class MailsProvider {

    @DataProvider(name = "valid-mails")
    public static Object[][] validMails() {
        return Arrays.stream(ValidMailsValues.values())
                .map(v -> new Object[]{v.getMail()})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "invalid-mails")
    public static Object[][] invalidMails() {
        return Arrays.stream(InvalidMailsValues.values())
                .map(v -> new Object[]{v.getMail()})
                .toArray(Object[][]::new);
    }
}
