package dataProviders;

import org.testng.annotations.DataProvider;

public class MailsProvider {
    private static Object[][] invalidMails;
    private static Object[][] validMails;

    @DataProvider(name = "valid-mails")
    public static Object[][] validMails(){
        if (validMails == null){
            synchronized (MailsProvider.class){
                if (validMails == null){
                    initValidMails();
                }
            }
        }
        return validMails;
    }

    @DataProvider(name = "invalid-mails")
    public static Object[][] invalidMails(){
        if (invalidMails == null){
            synchronized (MailsProvider.class){
                if (invalidMails == null){
                    initInvalidMails();
                }
            }
        }
        return invalidMails;
    }

    private static void initInvalidMails() {
        int maxRecipientNameLength = 64;
        StringBuilder RecipientNameToLength = new StringBuilder();
        for (int i = 0; i < maxRecipientNameLength + 1; i++) {
            char randomAlpha = (char) (97 + (Math.random() * 25));
            RecipientNameToLength.append(randomAlpha);
        }

        invalidMails = new Object[][] {
                {"testmaildomain.com"},
                {"@testmaildomain.com"},
                {"testmail@domaincom"},
                {"test.mail@domaincom"},
                {"testmail@.domaincom"},
                {RecipientNameToLength + "@domain.com"},
                {"testmail@domainco.m"},
                {"testmail@domain.abcdefghijk"}
        };
    }

    private static void initValidMails() {
        int maxRecipientNameLength = 64;
        StringBuilder RecipientNameMaxLength = new StringBuilder();
        for (int i = 0; i < maxRecipientNameLength; i++) {
            char randomAlpha = (char) (97 + (Math.random() * 25));
            RecipientNameMaxLength.append(randomAlpha);
        }
        validMails = new Object[][] {
                {"testmail@domain.com"},
                {"t@estmaildomain.com"},
                {"testmail@d.omaincom"},
                {RecipientNameMaxLength + "@domain.com"},
                {"testmail@domainc.om"},
                {"testmail@domain.abcdefghij"}
        };
    }
}
