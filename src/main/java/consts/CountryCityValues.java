package consts;

public enum CountryCityValues {
    VALUE00 ("Ukraine","Lviv"),
    VALUE01 ("Belarus","Brest");
//    VALUE02 ("Ukraine","Kyiv"),
//    VALUE03 ("Belarus","Gomel"),
//    VALUE04 ("Belarus","Gomel"),
//    VALUE05 ("Belarus","Gomel"),
//    VALUE06 ("Ukraine","Lutsk"),
//    VALUE07 ("Belarus","Grodno"),
//    VALUE08 ("Ukraine","Dnipro"),
//    VALUE09 ("Belarus","Minsk"),
//    VALUE10 ("Belarus","Mogilev"),
//    VALUE11 ("Belarus","Polotsk"),
//    VALUE12 ("Belarus","Vitebsk"),
//    VALUE13 ("Poland","Krakow"),
//    VALUE14 ("Ukraine","Rivne"),
//    VALUE15 ("Ukraine","Ternopil"),
//    VALUE16 ("Kazakhstan","Almaty"),
//    VALUE17 ("Kazakhstan","Karaganda");

    private final String country;
    private final String city;

    CountryCityValues(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
