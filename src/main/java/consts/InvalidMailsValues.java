package consts;

public enum InvalidMailsValues {
    VALUE00 ("testmaildomain.com"),
    VALUE01 ("@testmaildomain.com"),
    VALUE02 ("testmail@domaincom"),
    VALUE03 ("test.mail@domaincom"),
    VALUE04 ("testmail@.domaincom"),
    VALUE05 ("dddddddd@domain.com"),
    VALUE06 ("testmail@domainco.m"),
    VALUE07 ("testmail@domainco.moreThanTen"),
    VALUE08 ("tooLongMailllllllllllllllllllllllllllllllllllllllllllllllllllllll@domain.com");

    private final String mail;

    InvalidMailsValues(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
}
