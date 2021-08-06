package consts.values;

public enum MailValues {
    VALID(new String[]{
            "testmail@domain.com",
            "t@estmaildomain.com",
            "testmail@d.omaincom",
            "testmail@domainc.om",
            "testmail@domainc.maxxLength",
            "maxLengthMaillllllllllllllllllllllllllllllllllllllllllllllllllll@domain.com"
    }),
    INVALID(new String[]{
            "testmaildomain.com",
            "@testmaildomain.com",
            "testmaildomain.com",
            "test.mail@domaincom",
            "testmail@.domaincom",
            "testmail@domainco.m",
            "testmail@domainco.moreThanTen",
            "tooLongMailllllllllllllllllllllllllllllllllllllllllllllllllllllll@domain.com"}
    );

    private final String[] mails;

    MailValues(String[] mails) {
        this.mails = mails;
    }

    public String[] getMails() {
        return mails;
    }
}
