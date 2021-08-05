package consts;

public enum DriverConfigs {
    CHROME("webdriver.chrome.driver",
            "src/main/resources/chromedriver.exe"
    ),
    FIREFOX("webdriver.gecko.driver",
            "src/main/resources/geckodriver.exe"
    ),
    EDGE("webdriver.edge.driver",
            "src/main/resources/MicrosoftWebDriver.exe"
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

    public static final String DEFAULT_BROWSER_NAME = "webdriver.chrome.driver";
}
