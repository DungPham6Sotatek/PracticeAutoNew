import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
    private String result = "";
    private InputStream inputStream;

    public String getProperty(String key) {
        try {
            Properties properties = new Properties();
            String profileName = "framework.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(profileName);
            if (inputStream != null)
                properties.load(inputStream);
            else
                throw new FileNotFoundException("Not found file");
            String propertyValue = properties.getProperty(key);
            this.result = propertyValue;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }
}
