package consts;

public enum ValidMailsValues {
    VALUE00 ("testmail@domain.com"),
    VALUE01 ("t@estmaildomain.com"),
    VALUE02 ("testmail@d.omaincom"),
    VALUE03 ("testmail@domainc.om"),
    VALUE04 ("testmail@domainc.maxxLength"),
    VALUE05 ("maxLengthMaillllllllllllllllllllllllllllllllllllllllllllllllllll@domain.com");

    private final String mail;

    ValidMailsValues(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
}
