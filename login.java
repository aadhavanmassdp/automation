import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAutomation {
    
    @Test
    public void loginTest() {
        // Initialize ChromeDriver (Selenium Manager handles driver path in v4.11+)
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        try {
            // Navigate to login page
            driver.get("https://www.devcycles.com/users/sign_in");
            
            // Locate elements
            WebElement emailField = driver.findElement(By.id("user_email_login"));
            WebElement passwordField = driver.findElement(By.id("user_password"));
            WebElement loginButton = driver.findElement(By.name("commit"));
            
            // Enter credentials
            emailField.sendKeys("your_email@domain.com");
            passwordField.sendKeys("your_password");
            
            // Submit login
            loginButton.click();
            
            // Verification
            String expectedUrl = "https://live.devcycles.com/dashboard";
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl, "Login failed - URL mismatch");
            
        } finally {
            // Clean up
            driver.quit();
        }
    }
}
