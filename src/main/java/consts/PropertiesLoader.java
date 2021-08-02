package consts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {
    private static HashMap<String, String> properties;

    static {
        readProperties();
    }

    private PropertiesLoader() {
    }

    private static void readProperties() {
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(Constants.CONFIG_PROPERTIES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties = typeCastConvert(appProps);
    }

    @SuppressWarnings("unchecked")
    private static HashMap<String, String> typeCastConvert(Properties prop) {
        Map<String, String> step2 = (Map<String, String>) (Map) prop;
        return new HashMap<>(step2);
    }

    public static String getValue(String key) {
        return properties.get(key);
    }
    public static String buildKey(String tag, String key) {
        return tag + "." + key;
    }
}
