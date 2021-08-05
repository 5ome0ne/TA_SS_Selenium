package consts;

public enum Constants {
    CONFIG_PROP_PATH("src/main/resources/config.properties"),
    DRIVER_PROP_TAG("driver"),
    BUSINESS_PROP_TAG("business"),

    CORRECT_MAIL("ivanhorintest@gmail.com"),
    CORRECT_PASSWORD("ivanhorintestPassword");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
