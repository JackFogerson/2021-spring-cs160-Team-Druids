import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAutomation {

public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver", "C://Selenium/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    
    driver.get("http://localhost:3000/dashboard"); // Go to the Food Finder homepage
    
    long end = System.currentTimeMillis() + 5000;
    
    driver.findElement(By.className("btn-primary")).click(); // Find login button and click

    // Test Case: Login #1: Valid credentials
    // Login with valid credentials
    WebElement loginEmailElement = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/div/div/form/div/div/div[2]/input")); // Find email element
    WebElement loginPasswordElement = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/div/div/form/div/div/div[3]/input")); // Find password element
    
    loginEmailElement.sendKeys("user123@yahoo.com"); // Set email
    loginPasswordElement.sendKeys("pwd123"); // Set password

    driver.findElement(By.xpath("//input[@type='submit']")).click(); // Find login button and click
    
    end = System.currentTimeMillis() + 2000;
    while (System.currentTimeMillis() < end) {   }
    
    System.out.println("*** Test Case: Login #1 Valid credentials ***");
    System.out.println("Expected Url is: http://localhost:3000/dashboard");
    
    String strUrl = driver.getCurrentUrl();
    System.out.println("Result Url is: " + strUrl + "\n");
    
    end = System.currentTimeMillis() + 2000;
    while (System.currentTimeMillis() < end) {   }
    
    // Test Case: Restaurant Search #1
    WebElement restaurantSearch = driver.findElement(By.xpath("//*[@id=\"root\"]/header/div[2]/div/div[2]/form/div/div[1]/input")); // Find restaurant search bar element
    WebElement locationSearch = driver.findElement(By.xpath("//*[@id=\"root\"]/header/div[2]/div/div[2]/form/div/div[2]/input")); // Find location search bar element
    
    restaurantSearch.sendKeys("Chinese");
    locationSearch.sendKeys("95148");
    
    driver.findElement(By.xpath("//*[@id=\"root\"]/header/div[2]/div/div[2]/form/div/div[3]/button")).click(); // Find search button and click
    
    end = System.currentTimeMillis() + 2000;
    while (System.currentTimeMillis() < end) {   }
    
    List<WebElement> allSuggestions = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div"));
    
    System.out.println("*** Test Case: Restaurant Search #1: Cuisine and zipcode ***");
    System.out.println("Expected Result is: \n Evergreen Panda \n San Jose, CA \n ...");
    
    strUrl = driver.getCurrentUrl(); 
    
    System.out.println("Result is: ");	
    for (WebElement suggestion : allSuggestions) {
        System.out.println(suggestion.getText() + "\n");
    }
    
    end = System.currentTimeMillis() + 2000;
    while (System.currentTimeMillis() < end) {   }
    
    // Test Case: Sign Out
    driver.findElement(By.xpath("//*[@id=\"root\"]/nav/div/a[2]")).click(); // Find log out button
    
    end = System.currentTimeMillis() + 2000;
    while (System.currentTimeMillis() < end) {   }
    
    System.out.println("*** Test Case: Sign Out ***");
    System.out.println("Expected Url is: http://localhost:3000/login");
    
    strUrl = driver.getCurrentUrl();
    System.out.println("Result Url is: " + strUrl + "\n");
    
    // Test Case: Login #2: Invalid username
    // Login with invalid username
    loginEmailElement = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/div/div/form/div/div/div[2]/input")); // Find email element
    loginPasswordElement = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/div/div/form/div/div/div[3]/input")); // Find password element
    
    loginEmailElement.sendKeys("asdfghjkl"); // Set email
    loginPasswordElement.sendKeys("pwd123"); // Set password
    
    driver.findElement(By.xpath("//input[@type='submit']")).click(); // Find login button and click
    
    end = System.currentTimeMillis() + 2000;
    while (System.currentTimeMillis() < end) {   }
    
    System.out.println("*** Test Case: Login #2: Invalid username ***");
    System.out.println("Expected Url is: http://localhost:3000/login");
    
    strUrl = driver.getCurrentUrl();
    System.out.println("Result Url is: " + strUrl + "\n"); 
    
    driver.quit();
	}
}