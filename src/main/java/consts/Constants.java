package consts;

public enum Constants {
    CONFIG_PROPERTIES_PATH("src/main/resources/config.properties"),
    DRIVER_PROPERTY_TAG("driver"),
    BUSINESS_PROPERTY_TAG("business");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
