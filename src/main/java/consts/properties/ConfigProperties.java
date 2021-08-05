package consts.properties;

import consts.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigProperties {
    private static HashMap<String, String> properties;

    static {
        readProperties();
    }

    private ConfigProperties() {
    }

    private static void readProperties() {
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(Constants.CONFIG_PROP_PATH.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties = typeCastConvert(appProps);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static HashMap<String, String> typeCastConvert(Properties prop) {
        return new HashMap<>((Map<String, String>) (Map) prop);
    }

    public static String getValue(String key) {
        return properties.get(key);
    }

    private static String getFullKey(String tag, String key) {
        return tag + "." + key;
    }

    public static String getValue(String tag, String key) {
        return getValue(getFullKey(tag, key));
    }
}
