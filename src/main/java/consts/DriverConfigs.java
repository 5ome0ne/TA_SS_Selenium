package consts;

import utils.PropertiesLoader;

public enum DriverConfigs {
    CHROME(
            PropertiesLoader.getValue(
                    PropertiesLoader.buildKey(Constants.DRIVER_PROPERTY_TAG.getValue(), "CHROME_NAME")),
            PropertiesLoader.getValue(
                    PropertiesLoader.buildKey(Constants.DRIVER_PROPERTY_TAG.getValue(), "CHROME_DRIVER_LOCATION"))
    ),
    FIREFOX(PropertiesLoader.getValue(
                    PropertiesLoader.buildKey(Constants.DRIVER_PROPERTY_TAG.getValue(), "FIREFOX_NAME")),
            PropertiesLoader.getValue(
                    PropertiesLoader.buildKey(Constants.DRIVER_PROPERTY_TAG.getValue(), "EDGE_DRIVER_LOCATION"))
    ),
    EDGE(PropertiesLoader.getValue(
                    PropertiesLoader.buildKey(Constants.DRIVER_PROPERTY_TAG.getValue(), "EDGE_NAME")),
            PropertiesLoader.getValue(
                    PropertiesLoader.buildKey(Constants.DRIVER_PROPERTY_TAG.getValue(),"CHROME_DRIVER_LOCATION"))
    );

    private final String name;
    private final String path;

    DriverConfigs(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public final static String IMPLICITLY_WAIT_TIME = PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.DRIVER_PROPERTY_TAG.getValue(), "IMPLICITLY_WAIT_TIME"));

    public final static int DIVER_WAIT_TIME = Integer.parseInt(PropertiesLoader.getValue(PropertiesLoader
            .buildKey(Constants.DRIVER_PROPERTY_TAG.getValue(), "DIVER_WAIT_TIME")));

    public static final String DEFAULT_BROWSER_NAME = "webdriver.chrome.driver";

    }
