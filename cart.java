import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;

public class ShoppingCartAutomation {

    @Test
    public void testAddToCartButtons() {
        // Set the path to your ChromeDriver (or use Selenium Manager if using Selenium 4.11+)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Open the local HTML file
            String filePath = new File("path/to/your/shopping_cart.html").getAbsolutePath();
            driver.get("file:///" + filePath);

            // Find all "Add to Cart" buttons
            List<WebElement> addToCartButtons = driver.findElements(
                By.xpath("//button[contains(text(), 'Add to Cart')]")
            );

            // Click each "Add to Cart" button
            for (WebElement button : addToCartButtons) {
                button.click();
            }

            // OPTIONAL: Verify cart is updated (example: check if cart items are displayed)
            // This depends on your cart UI; here's a simple example if you have a cart item list
            // (Note: Your cart may not update the UI immediately if JS is not executed in Selenium;
            // you may need to wait or use JavaScriptExecutor to trigger the JS function)
            List<WebElement> cartItems = driver.findElements(
                By.cssSelector("#cart-items li:not(#empty-cart-msg)")
            );
            Assert.assertTrue(cartItems.size() > 0, "Cart should have items after adding products");

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
