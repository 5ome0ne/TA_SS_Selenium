package dataProviders;

import consts.values.MailValues;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class MailsProvider {

    @DataProvider(name = "valid-mails")
    public static Object[][] validMails() {
        return Arrays.stream(MailValues.VALID.getMails()).map(o -> new Object[]{o}).toArray(Object[][]::new);
    }

    @DataProvider(name = "invalid-mails")
    public static Object[][] invalidMails() {
        return Arrays.stream(MailValues.INVALID.getMails()).map(o -> new Object[]{o}).toArray(Object[][]::new);
    }
}
