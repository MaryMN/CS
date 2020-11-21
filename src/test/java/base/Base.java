package base;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    protected WebDriver driver;

    //constructor
    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver navigateTo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://loving-hermann-e2094b.netlify.app/index.html");
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver navigateToContactPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://loving-hermann-e2094b.netlify.app/contact.html");
        driver.manage().window().maximize();
        return driver;
    }

    @After
    public void tearDown() {
        driver.quit();
        System.out.println("Working Driver was closed.");
    }
}
