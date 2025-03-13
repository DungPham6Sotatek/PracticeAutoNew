import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
    // thiết kế đảm ba chỉ có một instance duy nhất tồn tại trong toàn bộ ứng dụng
        // getInstance đảm bảo rằng mỗi khi gọi, nó sẽ trả về cùng 1 đối tượng driverSingleton
        DriverSingleton driverSingleton = DriverSingleton.getInstance();
        WebDriver driver = driverSingleton.getDriver(); // getDriver trả về 1 thể hiện của WebDriver
        driver.get("https://magento.softwaretestingboard.com/");
    }
}
