import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplaintSubmittedPageTest {
    @Test
    public void testComplaintSubmittedPage() {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Open the local HTML file
            String filePath = new File("path/to/complaint_submitted.html").getAbsolutePath();
            driver.get("file:///" + filePath);

            // Verify the success message
            WebElement successH1 = driver.findElement(By.tagName("h1"));
            Assert.assertEquals(successH1.getText(), "Your Complaint Has Been Submitted!");

            WebElement thankYouP = driver.findElement(By.xpath("//p[contains(text(), 'Thank you for your feedback')]"));
            Assert.assertTrue(thankYouP.isDisplayed(), "Thank you message is not displayed");

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
