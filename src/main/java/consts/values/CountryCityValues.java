package consts.values;

public enum CountryCityValues {
    UKRAINE ("Ukraine","Lviv"),
    BELARUS ("Belarus","Brest"),
    POLAND ("Poland","Krakow"),
    KAZAKHSTAN ("Kazakhstan","Karaganda");

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
