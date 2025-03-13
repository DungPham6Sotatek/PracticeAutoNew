import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox implements DriverStrategy {
    @Override
    public WebDriver setStrategy() {
        WebDriverManager.firefoxdriver().setup();// cài đặt gekoDriver
        WebDriver driver = new FirefoxDriver();
        FirefoxOptions options = new FirefoxOptions();
        return driver;

    }
}
