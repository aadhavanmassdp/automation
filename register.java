import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;

public class RegistrationPageAutomation {

    public static void main(String[] args) {
        // Set the path to your ChromeDriver (or use Selenium Manager)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Open the registration page
            String filePath = new File("path/to/registration.html").getAbsolutePath();
            driver.get("file:///" + filePath);

            // Fill the form
            driver.findElement(By.id("username")).sendKeys("testuser");
            driver.findElement(By.id("email")).sendKeys("testuser@example.com");
            driver.findElement(By.id("password")).sendKeys("password123");
            driver.findElement(By.id("confirm-password")).sendKeys("password123");

            // Click the Register button
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // Wait for the alert to appear and accept it
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            alert.accept();

            // Optional: Verify the page after alert
            System.out.println("Registration form submitted successfully!");

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}