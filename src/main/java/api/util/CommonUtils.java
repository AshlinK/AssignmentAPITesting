package api.util;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtils {
    public static Properties readConfig() {
        Properties properties = new Properties();
        String value = null;
        try (InputStream inputStream = new FileInputStream(Constants.propertyFilePath)) {
            properties.load(inputStream);

        } catch (Exception e) {
            System.out.println(e);
        }
        return properties;
    }

    public static String get(Credential key){
        return readConfig().getProperty(key.toString());
    }

}
