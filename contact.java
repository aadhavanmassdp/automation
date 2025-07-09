import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactFormAutomation {

    public static void main(String[] args) {
        // Set the path to your ChromeDriver (or use Selenium Manager if using Selenium 4.11+)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Open the contact form HTML file
            driver.get("file:///path/to/contact.html"); // Adjust the path as needed

            // Fill First Name
            WebElement firstName = driver.findElement(By.id("fname"));
            firstName.sendKeys("John");

            // Fill Last Name
            WebElement lastName = driver.findElement(By.id("lname"));
            lastName.sendKeys("Doe");

            // Select Country
            Select country = new Select(driver.findElement(By.id("country")));
            country.selectByVisibleText("India"); // or "india" if case-sensitive

            // Fill Subject
            WebElement subject = driver.findElement(By.id("subject"));
            subject.sendKeys("This is a test message from Selenium automation.");

            // Click Submit
            WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
            submit.click();

            // Optional: Check for success or page change (not implemented in your form)
            System.out.println("Form submitted successfully!");

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
