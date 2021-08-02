package consts;

public enum DriverConfigs {
    ;

    public final static String CHROME_NAME = PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.DRIVER_PROPERTY_TAG, "CHROME_NAME"));
    public final static String FIREFOX_NAME = PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.DRIVER_PROPERTY_TAG, "FIREFOX_NAME"));
    public final static String EDGE_NAME = PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.DRIVER_PROPERTY_TAG, "EDGE_NAME"));
    public final static String CHROME_DRIVER_LOCATION = PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.DRIVER_PROPERTY_TAG, "CHROME_DRIVER_LOCATION"));
    public final static String FIREFOX_DRIVER_LOCATION = PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.DRIVER_PROPERTY_TAG, "FIREFOX_DRIVER_LOCATION"));
    public final static String EDGE_DRIVER_LOCATION = PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.DRIVER_PROPERTY_TAG, "EDGE_DRIVER_LOCATION"));
    public final static String IMPLICITLY_WAIT_TIME = PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.DRIVER_PROPERTY_TAG, "IMPLICITLY_WAIT_TIME"));

    public final static int DIVER_WAIT_TIME = Integer.parseInt(PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.DRIVER_PROPERTY_TAG, "DIVER_WAIT_TIME")));
}
