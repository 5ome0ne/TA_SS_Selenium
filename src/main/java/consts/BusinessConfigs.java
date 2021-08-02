package consts;

public enum BusinessConfigs {
    ;
    public final static String BASE_URL = PropertiesLoader
            .getValue(PropertiesLoader.buildKey(Constants.BUSINESS_PROPERTY_TAG, "BASE_URL"));

    public final static String HOME_PAGE_URL = BASE_URL + PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.BUSINESS_PROPERTY_TAG, "HOME_PAGE_URL"));

    public final static String CORRECT_MAIL = PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.BUSINESS_PROPERTY_TAG, "CORRECT_MAIL"));

    public final static String CORRECT_PASSWORD = PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.BUSINESS_PROPERTY_TAG, "CORRECT_PASSWORD"));
}
