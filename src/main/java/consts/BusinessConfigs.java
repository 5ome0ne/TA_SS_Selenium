package consts;

import utils.PropertiesLoader;

public enum BusinessConfigs {
    BASE_URL(PropertiesLoader.getValue(
            PropertiesLoader.buildKey(Constants.BUSINESS_PROPERTY_TAG.getValue(), "BASE_URL"))),
    HOME_PAGE_URL(BASE_URL.getValue() + PropertiesLoader.getValue(
            PropertiesLoader.buildKey(Constants.BUSINESS_PROPERTY_TAG.getValue(), "HOME_PAGE_URL"))),
    TRAINING_LIST_PAGE_URL(BASE_URL.getValue() + PropertiesLoader.getValue(
            PropertiesLoader.buildKey(Constants.BUSINESS_PROPERTY_TAG.getValue(), "TRAINING_LIST_PAGE_URL"))),

    BLOG_PAGE_URL(BASE_URL.getValue() + PropertiesLoader.getValue(
            PropertiesLoader.buildKey(Constants.BUSINESS_PROPERTY_TAG.getValue(), "BLOG_PAGE_URL"))),

    CORRECT_MAIL(PropertiesLoader.getValue(
            PropertiesLoader.buildKey(Constants.BUSINESS_PROPERTY_TAG.getValue(), "CORRECT_MAIL"))),
    CORRECT_PASSWORD(PropertiesLoader.getValue(
            PropertiesLoader.buildKey(Constants.BUSINESS_PROPERTY_TAG.getValue(), "CORRECT_PASSWORD")));

    private final String value;

    BusinessConfigs(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
