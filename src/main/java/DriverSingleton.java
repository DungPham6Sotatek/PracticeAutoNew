import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    // biến tĩnh static chứa đối tượng duy nhất của DriverSingleton
    private static WebDriver driver = null;
    // biến tĩnh chứa duy Webdriver, giúp đảm bảo chỉ có một trình duyệt duy nhất được mở

    // hàm khởi tạo đảm bảo rằng không thể tạo đối tượng driverSingleton từ bên ngoài
    // Khi DriverSingleton được khởi tạo nó mặc định sử dụng trình duyệt Chrome bằng cách gọi instance(chrome)
    private DriverSingleton() {
        instantiate("Chrome");
    }


    public WebDriver instantiate(String strategy) { // Nhận tham số Strategy tên trình duyệt: chrome hoăc firefox
        DriverStrategy driverStrategy = DriverStrategyImplement.chooseStrategy(strategy); // chọn trình duệt phù hợp

        driver = driverStrategy.setStrategy(); // gắn giá trị cho

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    // lấy thể hiện duy nhất của driverSingleton
    public static DriverSingleton getInstance() {
        if (instance == null) {
            instance = new DriverSingleton();
        }
        return instance;
    }
    public static void closeObjectInstance(){
        instance = null; // đặt instance = null để reset lại singleton -> giải phóng tài nguyên sau test
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
